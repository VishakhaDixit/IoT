import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowBikes {
    public static void main(String[] args) throws Exception{
        Connection con = conn();     //Connect to the Database

        String lastEle = "";         //Last attribute used to sort the list.
        String clause = "";          //String to create WHERE clause based on Cmd line input

        if(args.length > 0)
        {
            for (String val : args)
            {
                // If argument is separated by '-' then include it in Where clause condition
                if(val.contains("-"))                                       
                {
                    String[] arrOfStr = val.split("-", 2);
                    if(clause == "")
                    {
                        clause += arrOfStr[0] + "=" + "'" + arrOfStr[1] + "'";
                    }
                    else
                    {
                        clause += " AND " + arrOfStr[0] + "=" + "'" + arrOfStr[1] + "'";
                    }
                }
                else
                    lastEle = val;      
            }

            System.out.println(clause);
            String sql = "SELECT * FROM bicycles.attributes WHERE " + clause + " ORDER BY " + lastEle + " ASC";

            PreparedStatement stmt = con.prepareStatement(sql); 
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                System.out.print("Type= " + rs.getString("Type") + ", Number of Gears= " + rs.getString("Number_of_gears") 
                                + ", Wheel Base= " + rs.getString("Wheel_base") + ", Height= " + rs.getString("Height") + 
                                ", Color= " + rs.getString("Color") + ", Construction Material= " + rs.getString("Construction_material"));
                System.out.println("\n");
            }
        }   
    }

    public static Connection conn() {
        try {
            String driver = "com.mysql.jdbc.Driver";
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