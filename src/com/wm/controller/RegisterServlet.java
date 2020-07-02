package com.wm.controller;

import com.wm.Dao.UserDao;
import com.wm.Model.User;
import com.wm.util.DBUtil;
import com.wm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        request.setAttribute("account",account);
        HttpSession session = request.getSession();

        if(StringUtil.isEmpty(account)||StringUtil.isEmpty(password)){
            request.setAttribute("error1","用户名或密码不得为空！");
            System.out.println("yes");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }

        User user = new User(account,password);
        UserDao dao = new UserDao();
        Connection con = null;
        try {
            con = DBUtil.getCon();

            User currentUser= dao.register(con,user);
            request.setAttribute("success","注册成功!");
            request.getRequestDispatcher("register.jsp").forward(request,response);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                DBUtil.closeDB(con,null,null);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}
