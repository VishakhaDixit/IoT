import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PkgThread extends Thread 
{
    boolean run = true;
	public static final String[] locationArr = {"Northborough, MA","Edison, NJ","Pittsburgh, PA","Allentown, PA","Martinsburg, WV",
                                                "Charlotte, NC","Atlanta, GA","Orlando, FL","Memphis, TN","Grove City, OH","Indianapolis, IN",
                                                "Detroit, MI","New Berlin, WI", "Minneapolis, MN", "St. Louis, MO", "Kansas, KS", "Dallas, TX", 
                                                "Houston, TX","Denver, CO","Salt Lake City, UT","Phoenix, AZ","Los Angeles, CA","Chino, CA",
                                                "Sacramento, CA","Seattle, WA"};
	String location, currLocation;
	Thread t = new Thread();
	Package p;
	ArrayList<Integer> path = new ArrayList<Integer>();
	
    public PkgThread(Package p) 
    {
		this.p = p;
	}

    public void startThread() throws SQLException 
    {
		Connection conn = FedexDB.getConn();
		FedexDB.addPckgDet(conn, p);	
		
		PkgThread t = new PkgThread(p);
		t.start();
	}

	public void run() 
    {
		while(run) 
        {	
			TrackResult tr = new TrackResult();
			tr.init();
			
			int src = 0, dest = 0;
            DijkstrasAlgorithm algo = new DijkstrasAlgorithm();
			
            for(int i = 0; i < locationArr.length; i++) 
            {
				location = locationArr[i];
				if(location.equals(p.getSrc())) 
                {
					src = i; 
					tr.updateSrc(location);
				}
				if(location.equals(p.getDest())) 
                {
					dest = i;
					tr.updateDest(location);
				}
			}
			path = algo.getShortestPath(src, dest);
			tr.updateShippingFacts(p);
			
			for (int i = 0;i < path.size(); i++) 
            { 
				currLocation = locationArr[path.get(i)];
				p.setCurrLocation(currLocation);
				
                if(currLocation.equals(p.getDest())) 
                {
					run = false;
				}
				
				try 
                {
	                //Store it to Fedex DB
					Connection con = FedexDB.getConn();
					FedexDB.updateCurrLocation(con, p);
					tr.updateResult(p);

					System.out.println("Location = " + p.getCurrLocation() + ", " + "TrackingNumber = " + p.trackingNo);
					
					TimeUnit.SECONDS.sleep(5);
				} 
                catch (InterruptedException | SQLException e) 
                {
					System.out.println("Error in Timer");
					e.printStackTrace();
				}
			}
		}
	}
}
