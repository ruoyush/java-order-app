/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Ruoyu
 */
public class EmployeeUtil {
  private DataSource dataSource;
  
        public EmployeeUtil(DataSource theDataSource){
            dataSource = theDataSource;
        }
    
       public List<Employee> getEmployees() throws Exception{
	List<Employee> employees = new ArrayList<>();

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
        
        try{
            conn = dataSource.getConnection();
            String sql = "select e.id,e.name,e.email,e.aid,a.department from employees e inner join admins a on e.aid = a.id order by e.id";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {

                int id = rs.getInt("id");
                int aid = rs.getInt("aid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String department = rs.getString("department");

                Employee tempE = new Employee(id, name, email, aid, department);

                employees.add(tempE);

            }
            return employees;       
            
        }finally{
            close(conn, stmt, rs);
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

    public Employee getEmployee(String theEmpId) throws Exception{
        Employee theEmp = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int empId;

        try {
            empId = Integer.parseInt(theEmpId);
            conn = dataSource.getConnection();
            String sql = "select e.id,e.name,e.email,e.aid,e.pass, a.department from employees e inner join admins a on e.aid=a.id AND e.id = " + empId + "";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                int aid = rs.getInt("aid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("pass");
                String department = rs.getString("department");

                theEmp = new Employee(empId, name, email, password, aid, department);

            }else{
                throw new Exception("Could not find employee ID: "+ empId);
            }
            return theEmp;

        } finally {
            close(conn, stmt, rs);
        }
    }
    
    public void addEmployee(Employee theEmployee) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        String name = theEmployee.getName();
        String email = theEmployee.getEmail();
        String password = theEmployee.getPass();
        int aid = theEmployee.getAid();

        try {
            conn = dataSource.getConnection();
            String sql = "insert into employees"
                    + "(name,email,pass,aid)"
                    + "values('" + name + "','" + email + "','" + password + "'," + aid + ")";
            stmt = conn.prepareStatement(sql);

            stmt.execute();

        } finally {
            close(conn, stmt, null);
        }

    }
    
    public void updateEmployee(Employee theEmployee) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        String name = theEmployee.getName();
        String email = theEmployee.getEmail();
        String password = theEmployee.getPass();
        int aid = theEmployee.getAid();
        int id = theEmployee.getId();

        try {
            conn = dataSource.getConnection();
            String sql = "update employees set name="+"'"+name+"', email='"+email+"', pass='"+password+"', aid="+aid+" where id="+id+"";
            stmt = conn.prepareStatement(sql);

            stmt.execute();

        } finally {
            close(conn, stmt, null);
        }
    }

    public void deleteEmployee(String theEmpId) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;

        int id = Integer.parseInt(theEmpId);

        try {
            conn = dataSource.getConnection();
            String sql = "delete from employees where id=" + id + "";
            stmt = conn.prepareStatement(sql);

            stmt.execute();

        } finally {
            close(conn, stmt, null);
        }
    }
}
