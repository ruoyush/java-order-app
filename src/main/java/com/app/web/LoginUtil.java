/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class LoginUtil extends HttpServlet{
    
    private static final long serialVersionUID =1;
    
    private MenuUtil menuUtil;
            
    @Resource(name="jdbc/web")
    
    private DataSource dataSource;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("sessionUsername") != null){
            request.getRequestDispatcher("index.jsp").include(request, response);}
        else{
            response.sendRedirect("/web/login.jsp");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role =request.getParameter("role");
        String sql = null;

        Connection conn = null;
        PreparedStatement statement=null;
        ResultSet resultSet= null;
        PrintWriter out = response.getWriter();
        
        if(role.equals("admin")){
            sql = "SELECT count(id),id From admins WHERE email= ? " + "AND pass=? ";
        }else{
            sql = "SELECT count(id),id From employees WHERE email= ? " + "AND pass=? ";
        }

        HttpSession session = request.getSession();

        try{
            conn = dataSource.getConnection();

            statement = conn.prepareStatement(sql);
            statement.setString(1,email);
            statement.setString(2,password);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                int count = resultSet.getInt(1);
                if(count>0){
                        int id = resultSet.getInt("id");
                        session.setAttribute("sessionId", id);
                        session.setAttribute("sessionEmail", email);
                        session.setAttribute("sessionPassword", password);
                        session.setAttribute("sessionRole", role);
                        String message = "Welcome! "+email;
                        session.setAttribute("login_message", message);
                        request.getRequestDispatcher("/admin").forward(request, response);
                }else{
                        response.sendRedirect("/web");
                }
            }
        }catch(Exception exc){
            throw new ServletException(exc);
        }finally{
            close(conn, statement, resultSet);
        }

    }

    private void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
