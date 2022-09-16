import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class TestMyBicycles {
    public static void main(String[] args) 
    {
        try 
        {
            Connection con = conn();
            SearchTable st = new SearchTable();

            if(args.length > 0)
            {
                if(args[1] == "SearchTable")
                {   
                    ArrayList<String> cols = new ArrayList<String>();
                    ArrayList<String> tableList = new ArrayList<String>();

                    System.out.println("Was able to come here");
                    
                    for(int i = 2; i < args.length; i++)
                    {
                        cols.add(args[i]);
                    }
                    tableList = st.search(con, cols);

                    for(int i = 0; i < tableList.size(); i++)
                        System.out.println(tableList.get(i));
                }
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static Connection conn() 
    {
        try 
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306";
            String user = "root";
            String password = "Vishakha@96";

            Class.forName(driver);
            Connection connect = DriverManager.getConnection(url, user, password);

            return connect;
        } 
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
