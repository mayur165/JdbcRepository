package UsingRowID;

import java.io.FileInputStream;
import java.sql.*;

public class UsingRowIdInterface {
    public static void main(String[] args) throws Exception{
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL","oracle_db","mypassword");
        PreparedStatement ps = c.prepareStatement("select rowid,empid from employee");
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            RowId rd = rs.getRowId(1);
            byte[] b = rd.getBytes();
            String s = new String(b);
            System.out.println("Row id :"+s);
            System.out.println("Employee id :"+rs.getInt(2));
        }
        c.close();
    }
}
