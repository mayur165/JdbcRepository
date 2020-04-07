package CollegeManagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class CollegeDaoImpl {

    Connection getConnection() {

        Connection c = null;
        try {
            String url = "jdbc:oracle:thin:@localhost:1523:ORCL";
            String username = "oracle_db";
            String password = "mypassword";
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
        return c;

    }

    void cleanup(Connection c) {

        if (!c.equals(null)) {
            try {
                c.close();
            } catch (SQLException sq) {
                sq.printStackTrace();
            }
        }
    }

    public int addProfessor(Professor p) {
        int count = 0;
        Connection con = getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("insert into professor values(?,?,?)");
            ps.setInt(1, p.getProfessorId());
            ps.setString(2, p.getProfessorName());
            long time = p.getProfessorDob().getTime();
            java.sql.Date dob = new Date(time);
            ps.setDate(3, dob);
            count = ps.executeUpdate();
            System.out.println("Professor Details inserted :" + count);
        } catch (SQLException sf) {
            sf.printStackTrace();
        }
        cleanup(con);


        return count;
    }

    public int addCollege(College c) {
        Connection con = getConnection();
        int count = 0;
        try {
            PreparedStatement ps = con.prepareStatement("insert into college values(?,?,?)");
            ps.setInt(1, c.getCollegeId());
            ps.setString(2, c.getCollegeName());
            ps.setInt(3, c.getProfessorList());
            count = ps.executeUpdate();
            System.out.println("College Details inserted :" + count);
        } catch (SQLException sf) {
            sf.printStackTrace();
        }

        return count;
    }

    HashMap<String, ArrayList<String>> getCollegeMapByProfessor() {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        Connection c = getConnection();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select distinct p.professor_name,c.college_name from college c\n" +
                    "inner join professor p\n" +
                    "on c.professor_id = c.professor_id");
            while (rs.next()) {
                ArrayList<String> professorList = new ArrayList<>();
                if (map.containsKey(rs.getString(2))) {
                    map.get(rs.getString(2)).add(rs.getString(1));
                } else {
                    professorList.add(rs.getString(1));
                    map.put(rs.getString(2), professorList);
                }
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
        cleanup(c);
        return map;
    }
}
