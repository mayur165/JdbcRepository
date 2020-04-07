package Type1DriverConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcOdbcDriver {
    public static void main(String[] args) throws Exception{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c = DriverManager.getConnection("jdbc:odbc:demodsn1","scott","tiger");
        System.out.println("connection created");
        c.close();
    }
}
