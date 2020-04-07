package FirstJDBCProject;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("E:\\IntellijWorkspace\\JDBCProjects\\src\\FirstJDBCProject\\connection.properties");
        p.load(fis);
        Connection c = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
        Statement s = c.createStatement();
/*while(true) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the employee id ");
    int empId = sc.nextInt();
    System.out.println("Enter the employee name");
    String empname = sc.next();
    System.out.println("Enter the employee salary");
    int empsal = sc.nextInt();
    System.out.println("Enter the employee age");
    int empage = sc.nextInt();
    String sqlQuery = String.format("insert into employee values(%d,'%s',%d,%d)", empId, empname, empsal, empage);
    s.executeUpdate(sqlQuery);
    System.out.println("Records inserted");
    System.out.println("do you want to insert more records");
    String option = sc.next();
    if(option.equalsIgnoreCase("no"))
    {
        break;

   }*/
while(true) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the query");
    String query = sc.nextLine();
    boolean flag =s.execute(query);
    if (flag) {
        ResultSet rs = s.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getInt(4));
        }

    } else {
        s.executeUpdate(query);
        System.out.println("Records updated");
    }
    System.out.println("do you want to enter another query");
    String option =sc.next();
    if(option.equalsIgnoreCase("no"))
    {
        break;
    }
}
//ResultSet rs = s.executeQuery(query);


    }
}


