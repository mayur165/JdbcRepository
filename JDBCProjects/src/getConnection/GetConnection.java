package getConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    public static void main(String[] args) throws Exception{
     GetConnection c = new GetConnection();
     c.getConnection();
    }

    public Connection getConnection()throws SQLException
    {
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL","oracle_db","mypassword");

        return  c;
    }
}
