package com.wm.Dao;

import com.wm.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //登入 检测是否账户密码是否合法
    public static User login(Connection con,User user)throws SQLException{

        User resultUser = null;

        String sql="select * from accounts where account=?and password=?";      //sql查询语句

        PreparedStatement pstmt = con.prepareStatement(sql);                    //预处理

        pstmt.setString(1,user.getaccount());                   //设置账户名和密码为数据库中的值
        pstmt.setString(2,user.getpassword());

        ResultSet res = pstmt.executeQuery();                                   //执行sql语句

        if (res.next()){                                                        //将用户输入的账户信息和密码信息与查到的数据库互相绑定
            resultUser = new User();
            resultUser.setaccount("account");
            resultUser.setpassword("password");
        }
        return resultUser;

    }

    //注册
    public static User register(Connection con,User user) throws Exception {

        User resultUser = null;

        String sql = "INSERT INTO accounts(account,password)VALUES(?,?)";

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setString(1, user.getaccount());
        pstmt.setString(2, user.getpassword());

        pstmt.executeUpdate();

        return resultUser;
    }
}
