package com.wm.util;

import java.sql.*;
import java.util.logging.Logger;

public class DBUtil {

    //连接数据库所需要的信息
    private static String url="jdbc:mysql://localhost:3306/account?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String username="web";
    private static String password="896677";

    static {
        try{
            Class.forName(driver);
            System.out.println("加载数据库驱动成功！");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("加载数据库驱动失败！");
        }
    }

    private static Connection con=null;
    public static Connection getCon(){
        try{
            con = DriverManager.getConnection(url,username,password);
            System.out.println("数据库连接成功！");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库连接失败！");
        }
        return  con;
    }

    //关闭数据库连接
    public static  void closeDB(Connection con, PreparedStatement pstt,
                                ResultSet res)throws SQLException
    {
        if(con!=null){
            con.close();
        }
        if(pstt!=null){
            pstt.close();
        }
    }
}
