package NavyMgmtDemo.com;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public interface NavalMgmtDAO {
    int  addNavalOfficer(NavalOfficer navalOfficer);
    int  addBaseCamp(BaseCamp baseCamp);
    ArrayList<String> getOfficersNameSortedBySal();
    ArrayList<String> getOfficersNameForBaseCampLoc(String baseCampLoc);
    double getOfficersTotalSalOnBaseCamp(int baseCampId);

    default  Connection getConnection()
    {
        Connection c = null;
        try {
            FileInputStream fis = new FileInputStream("E:\\IntellijWorkspace\\JDBCProjects\\src\\NavyMgmtDemo\\com\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            Class.forName("oracle.jdbc.OracleDriver");
            c = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));

        }
        catch (Exception g)
        {
            g.printStackTrace();
        }
        return c;
    }

    default Statement createStatementMethod(Connection c)
    {
        Statement s =null;
        try {
             s = c.createStatement();
        }catch (SQLException sql)
        {
            System.out.println(sql);
        }
            return s;

    }
}
