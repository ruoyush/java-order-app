/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ruoyu
 */
public class LogoutUtil extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException,IOException {
        if(request.getSession()==null){
            response.sendRedirect("/web/index.jsp");
        }else{
            response.setContentType("text/html");
            HttpSession session=request.getSession();
            session.invalidate();
            response.sendRedirect("/web/index.jsp");
        }
    }


}
