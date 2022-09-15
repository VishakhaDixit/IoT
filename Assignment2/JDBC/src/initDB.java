import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class initDB {
    static final String URL = "jdbc:mysql://localhost:3306";
    static final String USERNAME = "root";
    static final String PASSWORD = "Vishakha@96";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
            System.out.println("You are now connected to Bicycles DB");
            System.out.println("Intializing Table called Attributes...");

            String[] type = {"mountain_bike", "race_bike", "street_bike"};
            int numOfGears = 4;
            int wheelBase = 36;
            int height = 1;
            String[] color = {"steel", "red", "blue", "black"};
            String[] consMaterial = {"carbon", "steel", "aluminium"};

            for(String t : type)
            {
                for(int g = numOfGears; g <= 10; g++)
                {
                    for(int wb = wheelBase; wb <= 60; )
                    {
                        for(int h = height; h <= 4; h++)
                        {
                            for(String clr : color)
                            {
                                for(String cm : consMaterial)
                                {
                                    String sql = "INSERT INTO `bicycles`.`attributes` (`Type`, `Number of Gears`, `Wheel Base`, `Height`, `Color`, `Construction Material`)" + "VALUES('"+t+"', "+g+", "+wb+", "+h+", '"+clr+"', '"+cm+"')";
                                    stmt.executeUpdate(sql);
                                }
                            }
                        }
                        wb += 6;
                    }
                }
            }
            
            System.out.println("Databse updates successfully");
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null)
                    con.close();
            } catch(SQLException se) {

            }
            try {
                if(con != null)
                    con.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
