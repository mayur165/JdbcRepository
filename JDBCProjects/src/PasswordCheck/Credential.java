package PasswordCheck;

import java.sql.*;
import java.util.Scanner;

public class Credential {
    public static void main(String[] args) {
        try(Connection  c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL","oracle_Db","mypassword"))
        {
            PreparedStatement ps =c.prepareStatement("select * from credential");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter username");
            String username = sc.next();
            System.out.println("Enter password");
            String pass = sc.next();
boolean flag = false;
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                if(username.equalsIgnoreCase(rs.getString(1)) && pass.equalsIgnoreCase(rs.getString(2)))
                {
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                System.out.println("Valid Credentials");
            }
            else {
                System.out.println("Login denied");
            }


        }
        catch (SQLException s )
        {
            s.printStackTrace();
        }
    }
}
