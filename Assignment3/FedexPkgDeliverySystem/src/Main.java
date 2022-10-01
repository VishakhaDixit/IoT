import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc = null;
        // Open MyPackages file to get list of all received packages for delivery.
        try 
        {
            System.out.println("Opening File\n");
            File file = new File("Packages.txt");
            sc = new Scanner(file);
            sc.useDelimiter(" - ");
        } 
        catch (Exception e) 
        {
            System.out.println("File not found!!!");
            return;
        }

        ArrayList<Package> pkgList = new ArrayList<Package>();
        while (sc.hasNext()) 
        {
			String weight = sc.next();
			String dimensions = sc.next();
			int pieces = sc.nextInt();
			String src = sc.next();
			String dest= sc.next();
			String signServices = sc.next();
			String packaging = sc.next();
			String specialHandling = sc.next();
			String service = sc.next();
            String trackingNum = sc.next();
			
            Package p = new Package(weight, dimensions, pieces, src, dest, signServices, packaging, specialHandling, service, trackingNum);
			pkgList.add(p);		
		}

		sc.close();

		Connection conn = FedexDB.getConn();
		FedexDB.clearDB();
        for(Package p : pkgList)
        {
		    FedexDB.addPckgDet(conn, p);	
        }
		
		PkgThread t[];
        t = new PkgThread[pkgList.size()];

		for(int i = 0; i < pkgList.size(); i++) 
        {
		  t[i] = new PkgThread(pkgList.get(i));
          System.out.println("\nThread " + i + ", " + "Tracking Number = " + t[i].p.trackingNo);
		  t[i].startThread();
        }
    } 
}
