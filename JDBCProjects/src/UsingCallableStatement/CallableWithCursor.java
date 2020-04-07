package UsingCallableStatement;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class CallableWithCursor {
    public static void main(String[] args) {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "oracle_db", "mypassword");
            CallableStatement cs = c.prepareCall("{ call readDataFromCursor(?,?)");
            cs.setInt(1,29000);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs =  (ResultSet)cs.getObject(2);
            while (rs.next())
            {
                System.out.println("EmployeeId :"+rs.getInt(1)+"\nEmployee Name :"+rs.getString(2)+"\nEmployee Sal :"+rs.getInt(3)+"\nEmployee Age :"+rs.getInt(4));
            }
        }
             catch (SQLException s)
            {
                s.printStackTrace();
            }
        finally{
                if(c!=null)
                {
                    try{
                        c.close();
                    }
                    catch(SQLException e){
                        e.printStackTrace();
                    }
                }
            }
    }
}
