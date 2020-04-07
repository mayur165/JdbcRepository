package JdbcPractice;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class Practice {
    public static void main(String[] args) {
        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL","oracle_db","mypassword");
            //CallableStatement cs = c.prepareCall("{call readDataFromCursor(?,?)}");
            CallableStatement cs = c.prepareCall("{? = call checkEven(?)");
            cs.registerOutParameter(1,Types.VARCHAR);
            cs.setInt(2,14);
            cs.executeQuery();
            String message = cs.getString(1);
            System.out.println(message);
        }
        catch (SQLException s )
        {
            s.printStackTrace();
        }
    }
}
