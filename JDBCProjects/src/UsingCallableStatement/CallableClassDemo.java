package UsingCallableStatement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class CallableClassDemo {
    public static void main(String[] args) {
        Connection c = null;
        try {
            Properties p = new Properties();
            FileInputStream fis = new FileInputStream("E:\\IntellijWorkspace\\JDBCProjects\\src\\FirstJDBCProject\\connection.properties");
            p.load(fis);
            c = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
            CallableStatement cs = c.prepareCall("{call sumTwoNumbers(?,?,?)}");
            cs.setInt(1,25);
            cs.setInt(2,65);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.execute();
            int sum= cs.getInt(3);
            System.out.println("sum is "+sum);
        } catch (IOException | SQLException k) {
            System.out.println(k);
        }
        finally {
            try {
                c.close();
            }
            catch (SQLException g)
            {
                g.printStackTrace();
            }
        }
    }
}
