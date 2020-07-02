package com.wm.Dao;

import com.wm.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //���� ����Ƿ��˻������Ƿ�Ϸ�
    public static User login(Connection con,User user)throws SQLException{

        User resultUser = null;

        String sql="select * from accounts where account=?and password=?";      //sql��ѯ���

        PreparedStatement pstmt = con.prepareStatement(sql);                    //Ԥ����

        pstmt.setString(1,user.getaccount());                   //�����˻���������Ϊ���ݿ��е�ֵ
        pstmt.setString(2,user.getpassword());

        ResultSet res = pstmt.executeQuery();                                   //ִ��sql���

        if (res.next()){                                                        //���û�������˻���Ϣ��������Ϣ��鵽�����ݿ⻥���
            resultUser = new User();
            resultUser.setaccount("account");
            resultUser.setpassword("password");
        }
        return resultUser;

    }

    //ע��
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
