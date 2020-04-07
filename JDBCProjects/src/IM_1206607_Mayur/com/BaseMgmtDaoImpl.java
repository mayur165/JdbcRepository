package IM_1206607_Mayur.com;

import java.sql.*;
import java.util.ArrayList;

public class BaseMgmtDaoImpl implements BaseMgmtDao{

    @Override
    public int addParticipant(Participant participant, DbTransaction dbobj) {
        Connection c= dbobj.getConnection();
        String query ="insert into "+dbobj.getTablename1()+" values(?,?,?,?,?)";
        int x =0;
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1,participant.getParticipant_id());
            ps.setString(2,participant.getParticipant_name());
            ps.setString(3,participant.getParticipant_stream());
            ps.setDouble(4,participant.getParticipant_sal());
            ps.setInt(5,participant.getBase_local_id());
            x = ps.executeUpdate();

            System.out.println("Count of participant inserted "+x);
        }
        catch (SQLException sq)
        {
            sq.printStackTrace();
        }
        finally {
            dbobj.closeConnection();
        }


        return x;
    }

    @Override
    public int addBaseLocat(BaseLocation baseLocat, DbTransaction dbobj) {
        Connection c= dbobj.getConnection();
        String query ="insert into "+dbobj.getTablename2()+" values(?,?,?)";
        int x =0;
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1,baseLocat.getBase_local_id());
            ps.setString(2,baseLocat.getBase_local_name());
            ps.setString(3,baseLocat.getBase_local_city());
            x = ps.executeUpdate();

            System.out.println("Count of base location inserted "+x);
        }
        catch (SQLException sq)
        {
            sq.printStackTrace();
        }
        finally {
            dbobj.closeConnection();
        }

        return x;
    }

    @Override
    public ArrayList<String> getParticipantNameSortedBySal(DbTransaction dbobj) {
        ArrayList<String> partList = new ArrayList<>();

            Connection c= dbobj.getConnection();
            String query ="select participant_name from tbl_participant_1206607 order by participant_sal desc";

        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next())
            {
                partList.add(rs.getString(1));
            }
            partList.forEach(i-> System.out.println(i));
        }
            catch (SQLException sr)
            {
                sr.printStackTrace();
            }
        finally {
            dbobj.closeConnection();
        }
        return partList;
    }

    @Override
    public ArrayList<String> getParticipantNameForBaseLocation(String baseLocationName, DbTransaction dbobj) {
        String query ="select tp.participant_name from  tbl_participant_1206607 tp\n" +
                "inner join\n" +
                "tbl_base_location_1206607 tb\n" +
                "on tp.base_locat_id = tb.base_locat_id \n" +
                "where tb.base_locat_name ="+"'"+baseLocationName+"'";
        ArrayList<String> partname = new ArrayList<>();
        Connection c = dbobj.getConnection();
        try{
            Statement s= c.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next())
            {
                partname.add(rs.getString(1));
            }
            partname.forEach(i-> System.out.println(i));

        }
        catch (SQLException k)
        {
            k.getCause();
        }

        finally {
            dbobj.closeConnection();
        }
        return partname;
    }

    @Override
    public int getTotalParticipantsInCity(String City, DbTransaction dbobj) {
        int num =0;
        String q = "select  count(tp.participant_name) from  tbl_participant_1206607 tp\n" +
                "inner join\n" +
                "tbl_base_location_1206607 tb\n" +
                "on tp.base_locat_id = tb.base_locat_id \n" +
                "where tb.base_locat_city ="+"'"+City+"'";
        Connection c = dbobj.getConnection();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(q);
            while(rs.next()) {
                num = rs.getInt(1);
            }
            System.out.println("Number of participant in "+City+" is: "+num);
        }
        catch (SQLException k)
        {
            System.out.println(k.getCause());
        }

        finally {
            dbobj.closeConnection();
        }

        return 0;
    }
}
