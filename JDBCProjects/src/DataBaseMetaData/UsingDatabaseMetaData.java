package DataBaseMetaData;

import java.sql.*;

public class UsingDatabaseMetaData {
    public static void main(String[] args) {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "oracle_db", "mypassword");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from employee");
            ResultSetMetaData rb = rs.getMetaData();
            System.out.println(rb.getColumnName(1));
//            DatabaseMetaData db = c.getMetaData();
//            String catalog =null;
//            String tablename = null;
//            String pattern = null;
//            String[] type = null;
//            ResultSet rs = db.getTables(catalog,pattern,tablename,type);
//
//            int count = 0;
//            while(rs.next())
//            {
//                System.out.println(rs.getString(3));
//                count++;
//            }
//            System.out.println("Number of tables in oracle :"+count);

        }
        catch (SQLException sq)
        {
            sq.printStackTrace();
        }
    }
}
