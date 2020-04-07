package CommitAndRollback;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CommitAndRollbackPractice {
    public static void main(String[] args) throws Exception{
        Connection c =null;
        Savepoint sv =null;

try{
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL","oracle_db","mypassword");
            System.out.println(c.getTransactionIsolation());
            DatabaseMetaData dbs = c.getMetaData();

            c.setAutoCommit(false);
           PreparedStatement ps = c.prepareStatement("insert into credential values(?,?,?)");
            String date = "12-01-2019";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date dd = sdf.parse(date);
            java.sql.Date dq= new Date(dd.getTime());
            ps.setString(1,"sameer");
            ps.setString(2,"password1");
            ps.setDate(3,dq);
            int x=ps.executeUpdate();
            PreparedStatement ps1 = c.prepareStatement("insert into credential values(?,?,?)");
            ps1.setString(1,"pankaj");
            ps1.setString(2,"password2");
            ps1.setDate(3,dq);
            int y =ps1.executeUpdate();
            sv= c.setSavepoint();
            PreparedStatement ps2 = c.prepareStatement("insert into credential values (?,?,?)");
            ps2.setString(1,"saransh");
            ps2.setString(2,"password3");
            ps2.setDate(3,dq);
            int z=ps2.executeUpdate();
            PreparedStatement ps3 = c.prepareStatement("insert into credential values(?,?,?)");
            ps3.setString(1,"deepak");
            ps3.setString(2,"password4");
            ps3.setDate(3,dq);
            int lp=ps3.executeUpdate();
            //PreparedStatement ps1 = c.prepareStatement("insert into credential values(?,?,?)");
            ps.setString(1,"pankaj");
            ps.setString(2,"password2");
            ps.setDate(3,dq);

            c.commit();
            System.out.println("Everything got commit");
        }
        catch (SQLException sq)
        {
            try {
                c.rollback(sv);
                System.out.println("Everything got rollbacked");
            }
            catch (SQLException sk)
            {
                sk.printStackTrace();
            }
            sq.printStackTrace();
        }
        catch (ParseException p)
        {
            p.printStackTrace();
        }
        finally {
            if(c!=null)
            {
                try{
                    c.close();
                }
                catch (SQLException sd)
                {
                    sd.printStackTrace();
                }
            }
        }

        }
}
