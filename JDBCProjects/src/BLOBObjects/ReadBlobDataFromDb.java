package BLOBObjects;

import getConnection.GetConnection;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * to read blob data from database
 */
public class ReadBlobDataFromDb {
    public static void main(String[] args) {
        GetConnection gc = new GetConnection();
        Connection c = null;
        try {
            c = gc.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from person");
            File f = new File("E:\\Java_Doc\\JDBC\\mayur.jpg");
            FileOutputStream fos = new FileOutputStream(f);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                String name = rs.getString(1);
                byte[] ot = new byte[1024];
                InputStream fis = rs.getBinaryStream(2);

                while(fis.read(ot)>0)
                {
                    fos.write(ot);
                }
                fos.flush();

            }

        }
        catch (SQLException sq)
        {
            sq.printStackTrace();
        }
        catch (FileNotFoundException f)
        {
            f.printStackTrace();
        }
        catch (IOException k)
        {
            k.printStackTrace();
        }
    }


}
