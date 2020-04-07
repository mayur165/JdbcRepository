package UsingCallableStatement;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class CallableStatementUsingFunction {
    public static void main(String[] args) {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL", "oracle_db", "mypassword");
            CallableStatement cs = c.prepareCall("{? = call getEmpAvgSal(?,?)");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
             cs.setInt(2,27000);
             cs.registerOutParameter(3,Types.INTEGER);
             cs.executeQuery();
             ResultSet rs = (ResultSet)cs.getObject(1);

             while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
            }
            System.out.println("count is  "+cs.getInt(3));
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