package ConnectionPool;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

import java.sql.*;

public class UsingDataSource {
    public static void main(String[] args) {
        try {
            OracleConnectionPoolDataSource os = new OracleConnectionPoolDataSource();
            os.setURL("jdbc:oracle:thin:@localhost:1523:orcl");
            os.setUser("oracle_db");
            os.setPassword("mypassword");
            Connection c = os.getConnection();
            Connection c1= os.getConnection();

            if(c==c1)
            {
                System.out.println("Equal");
            }
            else{
                System.out.println("Not Equal");
            }
            String q ="select empid from employee";
            PreparedStatement ps = c.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                System.out.println("Employee id :"+rs.getInt(1));
            }
        }
        catch (SQLException sw)
        {
         sw.printStackTrace();
        }

    }
}
