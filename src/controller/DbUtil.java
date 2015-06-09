package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	 
    private static String dbUrl="jdbc:mysql://localhost:3306/wenxuejiaoyushuju";
    private static String dbUserName="root";
    private static String dbPassword="1234";
    private static String jdbcName="com.mysql.jdbc.Driver";
    public static Connection getCon()throws Exception{
        Class.forName(jdbcName);
        Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return con;
    }
     
    public void close(Connection con)throws Exception{
        if(con!=null){
            con.close();           
        }
    }     
     
}
