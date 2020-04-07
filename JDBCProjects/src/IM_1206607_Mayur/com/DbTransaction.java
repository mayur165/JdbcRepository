package IM_1206607_Mayur.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTransaction {
    private String url;
    private String username;
    private String password;
    private String tablename1;
    private String tablename2;
    private Connection c;

    public DbTransaction(String url, String username, String password, String tablename1, String tablename2) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.tablename1 = tablename1;
        this.tablename2 = tablename2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTablename1() {
        return tablename1;
    }

    public void setTablename1(String tablename1) {
        this.tablename1 = tablename1;
    }

    public String getTablename2() {
        return tablename2;
    }

    public void setTablename2(String tablename2) {
        this.tablename2 = tablename2;
    }

    public Connection getConnection()
    {
        Connection c =null;
        try{
           c = DriverManager.getConnection(url,username,password);
        }
        catch (SQLException sq)
        {
            sq.printStackTrace();
        }
    return c;
    }

    public void closeConnection()
    {
        try{
            if(c!=null  && c.isClosed()==false)
            {
                c.close();
            }
        }
        catch (SQLException sq)
        {
            sq.printStackTrace();
        }
    }


}
