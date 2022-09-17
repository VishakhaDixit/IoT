import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class TestMyBicycles {
    public static void main(String[] args) 
    {
        try 
        {
            Connection con = conn();

            if(args.length > 0)
            {
                if(args[0].equals("SearchTable"))
                {   
                    SearchTable st = new SearchTable();
                    ArrayList<String> cols = new ArrayList<String>();
                    ArrayList<String> tableList = new ArrayList<String>();
                    
                    for(int i = 1; i < args.length; i++)
                    {
                        cols.add(args[i]);
                    }
                    tableList = st.search(con, cols);

                    for(int i = 0; i < tableList.size(); i++)
                        System.out.println(tableList.get(i));
                }
                else if(args[0].equals("DeleteRow"))
                {
                    DeleteRow dr = new DeleteRow();
                    ArrayList<String> cols = new ArrayList<String>();
                    Boolean result = false;
                    
                    for(int i = 1; i < args.length; i++)
                    {
                        cols.add(args[i]);
                    }
                    result = dr.delete(con, cols);

                    if(result)
                        System.out.println("Entry Deleted from the Table Attributes!!");
                    else
                        System.out.println("No Entries Deleted from the Table Attributes!!");
                }
                else if(args[0].equals("InsertRow"))
                {
                    InsertRow ir = new InsertRow();
                    ArrayList<String> cols = new ArrayList<String>();
                    Boolean result = false;
                    
                    for(int i = 1; i < args.length; i++)
                    {
                        cols.add(args[i]);
                    }
                    result = ir.insert(con, cols);

                    if(result)
                        System.out.println("Entry Inserted into the Table Attributes!!");
                    else
                        System.out.println("No Entries Inserted into the Table Attributes!!");
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
