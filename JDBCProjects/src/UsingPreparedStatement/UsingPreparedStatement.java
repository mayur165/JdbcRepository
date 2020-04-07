package UsingPreparedStatement;

import java.sql.*;

/*
Program to insert data into employee using prepared statement
 */
public class UsingPreparedStatement {
    public static void main(String[] args) {
        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL","oracle_db","mypassword");
            CallableStatement p= c.prepareCall("{ call addEmployee(?,?,?,?) }");
            p.setInt(1,2563);
            p.setString(2,"sandeep");
            p.setDouble(3,287444);
            p.setInt(4,16);
            int result = p.executeUpdate();
            System.out.println("No of employee inserted from java"+result);

        }
        catch (SQLException s)
        {
            System.out.println(s);
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
