import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchTable {
    public ArrayList<String> search(Connection conn, ArrayList<String> columns) 
    {
        try 
        {
            String cols = "";
            for(String val : columns)
            {
                if(cols == "")
                    cols += "'" + val + "'";
                else
                    cols += "," + "'" + val + "'";
            }

            String sql = "SELECT DISTINCT TABLE_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE COLUMN_NAME IN (cols) AND TABLE_SCHEMA='bicycles'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<String> list = new ArrayList<String>();

            while(rs.next()) 
            {
                list.add(rs.getString(1));
            }

            return list;
        } 
        catch(SQLException se) 
        {
            se.printStackTrace();
        }
        return null;
    }
}
