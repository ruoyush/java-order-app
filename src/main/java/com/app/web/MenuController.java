/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.web;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Ruoyu
 */
public class MenuController extends HttpServlet { 
    private static final long serialVersionUID =1;
    
    private MenuUtil menuUtil;
            
    @Resource(name="jdbc/web")
    private DataSource dataSource;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("page");
        String param2 = request.getParameter("command");
        
        if( param==null && param2==null){
            try {
                listMenus(request, response);
            } catch (Exception exc) {
                 throw new ServletException(exc);
            }
         }
        
        if(param !=null){
            try {
                if(param.equals("addmenu")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/add-menu.jsp");
                    dispatcher.forward(request, response);
                }else{
                    listMenus(request, response);
                }
                //response.sendRedirect("/web/admin/add-employee.jsp");
            } catch (Exception exc) {
                throw new ServletException(exc);
            }
        }
        
        if(param2!=null){
            try {
                        if(param2.equals("load")){
                            loadMenu(request,response);
                        }else if(param2.equals("update")){
                            updateMenu(request,response);
                        }else if(param2.equals("delete")){
                            deleteMenu(request,response);
                        }else{
                            listMenus(request, response);
                        }
            ;       }catch (Exception exc) {
                    throw new ServletException(exc);
                }
        }
    }
    
            
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.      
        try {
            menuUtil = new MenuUtil(dataSource);
            
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String param2 = request.getParameter("command");
        
        try {
            if (param2.equals("add")) {
                addMenu(request, response);
            }else{
                addMenu(request,response);
            }
        } catch (Exception exception) {
        }
    }

    private void listMenus(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        // get menus from db
        List<Menu> menus = menuUtil.getMenus();
        // add menus to the request
        request.setAttribute("menu_list", menus);
        // send to view
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/list-menus.jsp");
        dispatcher.forward(request, response);
    }

    private void addMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String entree = request.getParameter("entree");
        String drink = request.getParameter("drink");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String date = year+"-"+month+"-"+day;
        
        Menu theMenu = new Menu(entree,drink,date);
        
        menuUtil.addMenu(theMenu);
        
        //listMenus(request,response);
        String message = "Added Successfully!";
        request.getSession().setAttribute("message", message);
        response.sendRedirect("/web/admin/add-menu.jsp");
    }
    
    private void loadMenu(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        String theMenuId = request.getParameter("menuid");
        
        Menu theMenu = menuUtil.getMenu(theMenuId);
        
        request.setAttribute("the_menu", theMenu);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/load-menu.jsp");
        
        dispatcher.forward(request, response);
        
    }

    private void updateMenu(HttpServletRequest request, HttpServletResponse response) 
            throws Exception{

        String entree = request.getParameter("entree");
        String drink = request.getParameter("drink");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String date = year+"-"+month+"-"+day;
        
        Menu theMenu = new Menu(entree,drink,date);
        
        menuUtil.updateMenu(theMenu);
        String message = "Updated Successfully!";
        request.getSession().setAttribute("update_message", message);
        response.sendRedirect("/web/admin/menu");
        //listMenus(request,response);
    }

    private void deleteMenu(HttpServletRequest request, HttpServletResponse response) throws Exception{
         
        String theMenuId = request.getParameter("menuid");
         
        menuUtil.deleteMenu(theMenuId);
        
        //listMenus(request,response);
        String message = "Deleted Successfully!";
        request.getSession().setAttribute("delete_message", message);
        response.sendRedirect("/web/admin/menu");
    }
    
}
