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
public class EmployeeController extends HttpServlet { 
    private static final long serialVersionUID =1;
    
    private EmployeeUtil employeeUtil;
            
    @Resource(name="jdbc/web")
    private DataSource dataSource;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("page");
        String param2 = request.getParameter("command");
        
        if( param==null && param2==null){
            try {
                listEmployees(request, response);
            } catch (Exception exc) {
                 throw new ServletException(exc);
            }
            return;
         }
        
        if(param !=null){
            try {
                if(param.equals("addemp")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/add-employee.jsp");
                    dispatcher.forward(request, response);
                }else{
                    listEmployees(request, response);
                }
                //response.sendRedirect("/web/admin/add-employee.jsp");
            } catch (Exception exc) {
                throw new ServletException(exc);
            }
        }
        
        if(param2!=null){
            try {
                        if(param2.equals("load")){
                            loadEmployee(request,response);
                        }else if(param2.equals("update")){
                            updateEmployee(request,response);
                        }else if(param2.equals("delete")){
                            deleteEmployee(request,response);
                        }else{
                            listEmployees(request, response);
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
            employeeUtil = new EmployeeUtil(dataSource);
            
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param2 = request.getParameter("command");

        try {
            if (param2.equals("add")) {
                addEmployee(request, response);
            } else {
                listEmployees(request, response);
            }
        } catch (Exception exception) {
        }
    }
    
    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        // get employees from db
        List<Employee> employees = employeeUtil.getEmployees();
        // add employees to the request
        request.setAttribute("emoployee_list", employees);
        // send to view
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/list-employees.jsp");
        dispatcher.forward(request, response);
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int department = Integer.parseInt(request.getParameter("department"));
        
        Employee theEmployee = new Employee(name,email,password,department);
        
        employeeUtil.addEmployee(theEmployee);
        
        //listEmployees(request,response);
        String message = "Added Successfully!";
        request.getSession().setAttribute("message", message);
        response.sendRedirect("/web/admin/add-employee.jsp");
    }
    
    private void loadEmployee(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        String theEmpId = request.getParameter("empid");
        
        Employee theEmp = employeeUtil.getEmployee(theEmpId);
        
        request.setAttribute("the_emp", theEmp);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/load-employee.jsp");
        
        dispatcher.forward(request, response);
        
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
            throws Exception{
        int id = Integer.parseInt(request.getParameter("empid"));
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int department = Integer.parseInt(request.getParameter("department"));
        
        Employee theEmployee = new Employee(id, name,email,password,department);
        
        employeeUtil.updateEmployee(theEmployee);
        String message = "Updated Successfully!";
        request.getSession().setAttribute("update_message", message);
        response.sendRedirect("/web/admin/employee");
        //listEmployees(request,response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
         
        String theEmpId = request.getParameter("empid");
         
        employeeUtil.deleteEmployee(theEmpId);
        
        //listEmployees(request,response);
        String message = "Deleted Successfully!";
        request.getSession().setAttribute("delete_message", message);
        response.sendRedirect("/web/admin/employee");
    }
    
}
