/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Ruoyu
 */
public class OrderController extends HttpServlet { 
    private static final long serialVersionUID =1;
    
    private OrderUtil orderUtil;
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
                listOrders(request, response);
            } catch (Exception exc) {
                 throw new ServletException(exc);
            }
         }
        
        if(param !=null){
            try {
                if(param.equals("addorder")){
                    List<Menu> menus = menuUtil.getMenus();
                    request.setAttribute("menu_list", menus);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/add-order.jsp");
                    dispatcher.forward(request, response);
                }else{
                    listOrders(request, response);
                }
                //response.sendRedirect("/web/admin/add-employee.jsp");
            } catch (Exception exc) {
                throw new ServletException(exc);
            }
        }
        
        if(param2!=null){
            try {       if(param2.equals("delete")){
                            deleteOrder(request,response);
                        }else{
                            listOrders(request, response);
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
            orderUtil = new OrderUtil(dataSource);
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
                addOrder(request, response);
            }else{
                listOrders(request,response);
            }
        } catch (Exception exception) {
        }
    }

    private void listOrders(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        // get menus from db
        
        HttpSession session = request.getSession();
        
        String eid = session.getAttribute("sessionId").toString();
        String role = session.getAttribute("sessionRole").toString();
        
        List<Order> orders = orderUtil.getOrders(role, eid);
        // add menus to the request
        request.setAttribute("order_list", orders);
        // send to view
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/list-orders.jsp");
        dispatcher.forward(request, response);
    }

    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
     
        String meal = request.getParameter("choice");
        String[] items = meal.split("\\s*,\\s*");
        String eid_string = request.getSession().getAttribute("sessionId").toString();
        
        int eid = Integer.parseInt(eid_string);
        int mid = Integer.parseInt(items[0]);
        String mtype = request.getParameter("mtype");
        String ecomment = request.getParameter("ecomment");
      
        Order theOrder = new Order(eid,mid,mtype,ecomment);
        
        orderUtil.addOrder(theOrder);
        
        //listMenus(request,response);
        String message = "Added Successfully!";
        request.getSession().setAttribute("message", message);
        response.sendRedirect("/web/admin/add-order.jsp");
    }
 /*   
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
*/
    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws Exception{
         
        String theOrderId = request.getParameter("orderid");
         
        orderUtil.deleteOrder(theOrderId);
        
        //listMenus(request,response);
        String message = "Deleted Successfully!";
        request.getSession().setAttribute("delete_message", message);
        response.sendRedirect("/web/admin/order");
    }
    
}