import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class InsertRow {
    public Boolean insert(Connection conn, ArrayList<String> columns) 
    {
        try {
            String t = "", clr = "", cm = "";
            int g = 0, h = 0, wb = 0;
            String sql = "";

            if(columns.size() != 0)
            {
                for(String val : columns)
                {
                    String[] arrOfStr = val.split("-", 2);
                    
                    if(arrOfStr[0].equals("Type"))
                        t = arrOfStr[1];
                    else if(arrOfStr[0].equals("Color"))
                        clr = arrOfStr[1];
                    else if(arrOfStr[0].equals("Construction_material"))
                        cm = arrOfStr[1];
                    else if(arrOfStr[0].equals("Number_of_gears"))
                        g = Integer.parseInt(arrOfStr[1]);
                    else if(arrOfStr[0].equals("Height"))
                        h = Integer.parseInt(arrOfStr[1]);
                    else 
                        wb = Integer.parseInt(arrOfStr[1]);
                }
                
                sql = "INSERT INTO `bicycles`.`attributes` (`Type`, `Number_of_gears`, `Wheel_base`, `Height`, `Color`, `Construction_material`)" + "VALUES('"+t+"', "+g+", "+wb+", "+h+", '"+clr+"', '"+cm+"')";
                PreparedStatement stmt = conn.prepareStatement(sql); 
                int rs = stmt.executeUpdate(sql);

                System.out.println("Inserted in Row: "+ rs);
                return true;
            }
        } catch (SQLException se) {
           se.printStackTrace();
        }
        return false;
    }
}
