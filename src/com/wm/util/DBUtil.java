package com.wm.util;

import java.sql.*;
import java.util.logging.Logger;

public class DBUtil {

    //�������ݿ�����Ҫ����Ϣ
    private static String url="jdbc:mysql://localhost:3306/account?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String username="web";
    private static String password="896677";

    static {
        try{
            Class.forName(driver);
            System.out.println("�������ݿ������ɹ���");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("�������ݿ�����ʧ�ܣ�");
        }
    }

    private static Connection con=null;
    public static Connection getCon(){
        try{
            con = DriverManager.getConnection(url,username,password);
            System.out.println("���ݿ����ӳɹ���");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("���ݿ�����ʧ�ܣ�");
        }
        return  con;
    }

    //�ر����ݿ�����
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
