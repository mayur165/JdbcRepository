package BLOBObjects;

import getConnection.GetConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class UsingBlobClass {
    public static void main(String[] args) {
        GetConnection gc = new GetConnection();
        Connection c = null;
        try{
            c = gc.getConnection();
            File f = new File("E:\\My_Photos\\GoaTrip\\IMG20190504185829.jpg");
            FileInputStream fis = new FileInputStream(f);
            String query ="insert into person values(?,?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1,"Mayur");
            ps.setBinaryStream(2,fis);
            ps.executeUpdate();
            System.out.println("Inserted sucessfully");
        }
        catch (SQLException qs)
        {
            qs.printStackTrace();
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
        finally {
            try{
                c.close();
            }
            catch (SQLException sp) {
                System.out.println(sp);
            }

        }
    }
}
