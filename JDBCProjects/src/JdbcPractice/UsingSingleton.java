package JdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UsingSingleton {
    private static Connection c = null;
    static String url = "jdbc:oracle:thin:@localhost:1523:ORCL";
    static String username ="oracle_db";
    static String password ="mypassword";
    public static Connection getConnection()
    {
        try {
            if (c == null) {
                return c = DriverManager.getConnection(url, username, password);
            }
        }
        catch (SQLException s)
        {
            s.printStackTrace();
        }
    return c;
    }

    public static void main(String[] args) {
        Connection c= UsingSingleton.getConnection();
        Connection c1 = UsingSingleton.getConnection();
        if(c==c1)
        {
            System.out.println("Equal");
        }
        else{
            System.out.println("Not equal");
        }
    }
}
