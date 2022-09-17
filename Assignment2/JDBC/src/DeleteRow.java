import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class DeleteRow {
    public Boolean delete(Connection conn, ArrayList<String> columns) 
    {
        try 
        {
            String clause = "";
            String sql = "";

            if(columns.size() != 0)
            {
                for(String val : columns)
                {
                    String[] arrOfStr = val.split("-", 2);
                    if(clause == "")
                    {
                        clause += arrOfStr[0] + "=" + arrOfStr[1];
                    }
                    else
                    {
                        clause += " AND " + arrOfStr[0] + "=" + arrOfStr[1];
                    }
                }

                sql = "DELETE FROM bicycles.attributes WHERE " + clause;
                PreparedStatement stmt = conn.prepareStatement(sql); 
                int rs = stmt.executeUpdate(sql);

                System.out.println(rs);

                return true;
            }
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        return false;
    }
}
