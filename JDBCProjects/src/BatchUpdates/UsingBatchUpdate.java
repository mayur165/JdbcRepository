package BatchUpdates;

import java.sql.*;

public class UsingBatchUpdate {
    public static void main(String[] args) {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "oracle_db", "mypassword");
            Statement s = c.createStatement();
            s.addBatch("select * from employee");
            s.addBatch("insert into employee values(1000,'rawatji',12547,29)");
            s.addBatch("delete from employee where empId = 2563");
            s.addBatch("update employee set empSal =25 where empId = 1205");
            int[] x= s.executeBatch();
            for(int l:x)
            {
                System.out.println("Inside loop "+l);
            }
        } catch (SQLException s) {
            System.out.println(s);
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}