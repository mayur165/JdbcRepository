package UsingRowSet;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class UsingJdbcRowSet {
    public static void main(String[] args) throws Exception{
        RowSetFactory rs = RowSetProvider.newFactory();
        JdbcRowSet jd = rs.createJdbcRowSet();
        jd.setUrl("jdbc:oracle:thin:@localhost:1523:ORCL");
        jd.setUsername("oracle_db");
        jd.setPassword("mypassword");

        jd.setCommand("select * from employee");
        jd.execute();
        while(jd.next())
        {
            System.out.println(jd.getInt(1));
        }

    }
}
