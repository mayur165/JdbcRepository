package CLOBObjects;

import getConnection.GetConnection;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDataFromClob {
    public static void main(String[] args) {
        GetConnection gc = new GetConnection();
        Connection c = null;
        try {
            c = gc.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from resume");
            File f = new File("E:\\Java_Doc\\JDBC\\mayur.txt");
            PrintWriter pw = new PrintWriter(f);
            ResultSet  rs = ps.executeQuery();
            if(rs.next())
            {
                String x = rs.getString(1);
                Reader btr = rs.getCharacterStream(2);
                BufferedReader r = new BufferedReader(btr);
                String rp= r.readLine();
                while(rp!=null)
                {
                    pw.println(rp);
                    rp=r.readLine();
                }
                pw.flush();

            }
            System.out.println("Data retrieval is sucessfull");

        }
        catch (SQLException sw)
        {
            sw.printStackTrace();
        }
        catch (FileNotFoundException fp)
        {
            fp.printStackTrace();
        }
        catch (IOException kl){
            kl.printStackTrace();
        }
    }
}
