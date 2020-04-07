package NavyMgmtDemo.com;

import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;

public class NavalMgmtDAOImpl implements NavalMgmtDAO {

    @Override
    public int addNavalOfficer(NavalOfficer navalOfficer) {
        int insertedcountnew = 0;
        Connection c = null;
        try {
             c= getConnection();
            //Statement s = createStatementMethod(c);
            String sqlquery ="insert into tbl_officer_1206607 values(?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sqlquery);
            ps.setInt(1,navalOfficer.getOfficeId());
            ps.setString(2,navalOfficer.getOfficerName());
            ps.setString(3,navalOfficer.getOfficeRank());
            ps.setDouble(4,navalOfficer.getOfficerSal());
            ps.setInt(5,navalOfficer.getBaseCampId());
            int count =ps.executeUpdate();
            System.out.println("Number of naval officer inserted "+count);
            return count;
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
        finally {
            if(c!=null)
            {
                try {
                    c.close();
                    }
                catch (SQLException s)
                {
                    s.printStackTrace();
                }

            }
        }

        return insertedcountnew;
    }

    @Override
    public int addBaseCamp(BaseCamp baseCamp) {
        int insertedcountnew=0;
        Connection c =null;
        Statement s =null;
        try {
           String query = "insert into tbl_base_camp_1206607(base_camp_id ,base_camp_name,base_camp_loc) values("+baseCamp.getBaseCampId()+","+"'"+baseCamp.getBaseCampName()+"'"+","+"'"+baseCamp.getBaseCampLoc()+"'"+")";
           c = getConnection();
            s = createStatementMethod(c);
            int count= s.executeUpdate(query);
            System.out.println("Number of base camp inserted "+count);
        }
 catch (SQLException e)
 {
     System.out.println(e);
 }
        finally {
            if(s!=null)
            {
                try {
                    s.close();
                }
                catch (SQLException s1)
                {
                    s1.printStackTrace();
                }
            }
            if(c!=null)
            {
                try {
                    c.close();
                }
                catch (SQLException s2)
                {
                    s2.printStackTrace();
                }
            }
        }
        return insertedcountnew;

    }

    @Override
    public ArrayList<String> getOfficersNameSortedBySal() {
        ArrayList<String> officerList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c=getConnection();
            String query ="select OFFICER_NAME from tbl_officer_1206607 order by OFFICER_SAL asc";
            ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                officerList.add(rs.getString(1));
            }
            officerList.forEach(i-> System.out.println(i));
        }
        catch (SQLException sq)
        {
            sq.printStackTrace();
        }
        finally {
            if(ps!=null)
            {
                try {
                    ps.close();
                }
                catch (SQLException s1)
                {
                    s1.printStackTrace();
                }
            }
            if(c!=null)
            {
                try {
                    c.close();
                }
                catch (SQLException s2)
                {
                    s2.printStackTrace();
                }
            }
        }
        return officerList;
    }

    @Override
    public ArrayList<String> getOfficersNameForBaseCampLoc(String baseCampLoc) {
        ArrayList<String> officerName = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c=getConnection();
            String query ="select nv.officer_name from  tbl_officer_1206607 nv inner join tbl_base_camp_1206607 bs on nv.base_camp_id = bs.base_camp_id where bs.base_camp_loc ="+"'"+baseCampLoc+"'";
            ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                officerName.add(rs.getString(1));
            }
            officerName.forEach(i-> System.out.println(i));
        }
        catch (SQLException sq)
        {
            sq.printStackTrace();
        }
        finally {
            if(ps!=null)
            {
                try {
                    ps.close();
                }
                catch (SQLException s1)
                {
                    s1.printStackTrace();
                }
            }
            if(c!=null)
            {
                try {
                    c.close();
                }
                catch (SQLException s2)
                {
                    s2.printStackTrace();
                }
            }
        }
        return officerName;
    }

    @Override
    public double getOfficersTotalSalOnBaseCamp(int baseCampId) {
        double sal = 0;
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c=getConnection();
            String query ="select sum(officer_sal) from  tbl_officer_1206607 nv inner join tbl_base_camp_1206607 bs on nv.base_camp_id = bs.base_camp_id where bs.base_Camp_id ="+baseCampId;
            ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                sal=rs.getInt(1);
            }
            System.out.println("Salary of officer "+sal);
        }
        catch (SQLException sq)
        {
            sq.printStackTrace();
        }
        finally {
            if(ps!=null)
            {
                try {
                    ps.close();
                }
                catch (SQLException s1)
                {
                    s1.printStackTrace();
                }
            }
            if(c!=null)
            {
                try {
                    c.close();
                }
                catch (SQLException s2)
                {
                    s2.printStackTrace();
                }
            }
        }
        return sal;
    }
}
