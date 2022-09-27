import java.sql.*;

public class FedexDB {
    public static Connection getConn() 
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
        }
        return null;
    }

    public static void clearDB() throws SQLException 
    {
        Connection conn = getConn();
        String sql = "DELETE FROM fedex.package_details";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);

        String sql1 = "DELETE FROM fedex.travel_history";
        Statement stmt1 = conn.createStatement();
        stmt1.executeUpdate(sql1);
    }

    public static void addPckg(Connection conn, Package p) throws SQLException
    {
        String sql = "INSERT INTO `fedex`.`package_details` (`Weight`, `Source`, `Destination`, `SignService`, `Packaging`, `TotalPieces`, `Service`, `TrackingNumber`, `SpecialHandling`)" + 
        "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, p.getWeight());
		stmt.setString(2, p.getSrc());
		stmt.setString(3, p.getDest());
		stmt.setString(4, p.getSignServices());
		stmt.setString(5, p.getPackaging());
		stmt.setInt(6,    p.getTotalPieces());
		stmt.setString(7, p.getSpecialHandlingSrvc());
		stmt.setString(8, p.getService());
		stmt.setString(9, p.trackingNo);
		stmt.executeUpdate();
		conn.close();
    }
}
