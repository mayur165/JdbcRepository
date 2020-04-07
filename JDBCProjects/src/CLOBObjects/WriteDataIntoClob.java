package CLOBObjects;

import getConnection.GetConnection;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * write date into clob db
 */
public class WriteDataIntoClob {
    public static void main(String[] args) {
        GetConnection gc = new GetConnection();
        Connection c = null;
        try {
            c = gc.getConnection();
            PreparedStatement ps = c.prepareStatement("insert into resume values(?,?)");
            File f = new File("E:\\Java_Doc\\Java_Cons.txt");
            try(BufferedReader br = new BufferedReader(new FileReader(f)))
            {
                ps.setString(1,"Mayur");
                ps.setCharacterStream(2,br);
                int gg = ps.executeUpdate();
                if(gg==1)
                {
                    System.out.println("Records Inserted");
                }
                else{
                    System.out.println("Somethin went wrong");
                }
            }
            catch(FileNotFoundException fk)
            {
                fk.printStackTrace();
            }
            catch (IOException k)
            {
                k.printStackTrace();
            }
        }
        catch (SQLException s)
        {
            s.printStackTrace();
        }
    }
}
