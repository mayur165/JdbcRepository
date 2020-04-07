package UsingPreparedStatement;

import getConnection.GetConnection;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTypeWithPreparedStatement {
    public static void main(String[] args) {
        Connection c = null;
        GetConnection gt = new GetConnection();
        try{
            c = gt.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from credential");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                System.out.println("username "+rs.getString(1)+"\n"+"password :"+rs.getString(2)+"\n"+"Creation date :"+rs.getDate(3));
            }
        }
        catch (SQLException sq){
            System.out.println(sq.getMessage());
    }
        finally {
            if(c!=null)
                try{
                    c.close();
                }
                catch (SQLException s )
                {
                    s.printStackTrace();
                }
        }
    }
}
