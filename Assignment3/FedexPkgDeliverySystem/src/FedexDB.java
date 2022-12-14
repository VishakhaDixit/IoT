import java.sql.*;

public class FedexDB {
    public static Connection getConn() throws SQLException
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

    public static void addPckgDet(Connection conn, Package p) throws SQLException
    {
        String sql = "INSERT INTO `fedex`.`package_details` (`Weight`, `Source`, `Destination`, `SignService`, `Packaging`, `TotalPieces`, `Service`, `TrackingNumber`, `SpecialHandling`, `Dimension`)" + 
        "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";        
        PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, p.getWeight());
		stmt.setString(2, p.getSrc());
		stmt.setString(3, p.getDest());
		stmt.setString(4, p.getSignServices());
		stmt.setString(5, p.getPackaging());
		stmt.setInt(6,    p.getTotalPieces());
		stmt.setString(7, p.getService());
		stmt.setString(8, p.trackingNo);
		stmt.setString(9, p.getSpecialHandlingSrvc());
        stmt.setString(10, p.getDimensions());
		stmt.executeUpdate();
    }

    public static void updateCurrLocation(Connection conn, Package p) throws SQLException
    {
        String currLocation = p.getCurrLocation();
		String sql = "UPDATE `fedex`.`package_details` SET CurrentLocation='"+currLocation+"' WHERE TrackingNumber="+ p.trackingNo;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.executeUpdate(sql);

		String insert_query = "INSERT INTO `fedex`.`travel_history` (ArrivalTime, TrackingNumber, Location) values (?, ?, ?)";
		PreparedStatement historyStmt = conn.prepareStatement(insert_query);
		historyStmt.setLong(1, System.currentTimeMillis());
		historyStmt.setString(2, p.trackingNo);
		historyStmt.setString(3, currLocation);
		historyStmt.executeUpdate();
    }
}
