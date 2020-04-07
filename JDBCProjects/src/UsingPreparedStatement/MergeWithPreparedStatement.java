package UsingPreparedStatement;

import getConnection.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MergeWithPreparedStatement {
    public static void main(String[] args) {
        Connection c =null;
    GetConnection gc = new GetConnection();
            try{
                c = gc.getConnection();
                String query = "MERGE INTO EMPLOYEE emp using (select ? as empId , ? as empname,? as empsal,? as empage,? as deptId from dual) source_table\n" +
                        "on (emp.empId = source_table.empId)\n" +
                        "when matched\n" +
                        "then update  set empname = source_table.empname , empsal = source_table.empsal , empage = source_table.empage ,deptId = source_table.deptId \n" +
                        "when not matched\n" +
                        "then insert  values(source_table.empId ,source_table.empname , source_table.empsal , source_table.empage ,source_table.deptId)";
                PreparedStatement ps = c.prepareStatement(query);
                ps.setInt(1,65325);
                ps.setString(2,"akriti");
                ps.setInt(3,9856325);
                ps.setInt(4,29);
                ps.setInt(5,101);

                int x =ps.executeUpdate();
                System.out.println("Records insert :"+x);

            }
            catch (SQLException s)
            {
                s.printStackTrace();
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
