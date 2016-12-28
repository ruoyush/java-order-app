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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Ruoyu
 */
public class OrderUtil{
  private DataSource dataSource;
  
        public OrderUtil(DataSource theDataSource){
            dataSource = theDataSource;
        }
    
       public List<Order> getOrders(String roleType, String theRoleId) throws Exception{
		List<Order> orders = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
                String sql =null;
                int roleId;
        
        try{
            conn = dataSource.getConnection();
            roleId = Integer.parseInt(theRoleId);
            if(!roleType.equals("admin")){
                sql = "select o.id,o.eid, o.mid, m.entree, m.drink, o.mtype, o.ecomment,m.date from orders o inner join menus m on o.mid = m.id AND o.eid=" + roleId + " order by o.date";
            }else{
                sql = "select o.id,o.eid, o.mid, m.entree, m.drink, o.mtype, o.ecomment,m.date from orders o inner join menus m on o.mid = m.id order by o.date";
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {

                int id = rs.getInt("id");
                int eid = rs.getInt("eid");
                int mid = rs.getInt("mid");
                String mtype = rs.getString("mtype");
                String entree = rs.getString("entree");
                String drink = rs.getString("drink");
                String date = rs.getString("date");
                String ecomment = rs.getString("ecomment");

                Order tempO = new Order(id, eid, mid, mtype, ecomment,date, entree, drink);

                orders.add(tempO);

            }
            return orders;       
            
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

    public Order getOrder(String theOrderId, String theRoleId) throws Exception{
        Order theOrder = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int orderId, roleId;

        try {
            orderId = Integer.parseInt(theOrderId);
            roleId = Integer.parseInt(theRoleId);
            conn = dataSource.getConnection();
            String sql = "select o.id,o.eid, o.mid, m.entree, m.drink, o.mtype, o.ecomment,m.date from orders o inner join menus m on o.mid = m.id and m.id=" + orderId + " o.eid=" + roleId + "";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                int id = rs.getInt("id");
                int eid = rs.getInt("eid");
                int mid = rs.getInt("mid");
                String mtype = rs.getString("mtype");
                String entree = rs.getString("entree");
                String drink = rs.getString("drink");
                String date = rs.getString("date");
                String ecomment = rs.getString("ecomment");

                theOrder = new Order(eid, mid, mtype, entree, drink, ecomment, date);

            }else{
                throw new Exception("Could not find Order ID: "+ orderId);
            }
            return theOrder;

        } finally {
            close(conn, stmt, rs);
        }
    }
    
    public void addOrder(Order theOrder) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        int eid = theOrder.getEid();
        int mid = theOrder.getMid();
        String mtype = theOrder.getMtype();
        String ecomment = theOrder.getEcomment();

        try {
            conn = dataSource.getConnection();
            String sql = "insert into orders (eid,mtype,mid,ecomment) values('" + eid + "','" + mtype + "','" + mid + "','" + ecomment + "\')";
            stmt = conn.prepareStatement(sql);

            stmt.execute();

        } finally {
            close(conn, stmt, null);
        }

    }
    

    public void deleteOrder(String theOrderId) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;

        int id = Integer.parseInt(theOrderId);

        try {
            conn = dataSource.getConnection();
            String sql = "delete from orders where id=" + id + "";
            stmt = conn.prepareStatement(sql);

            stmt.execute();

        } finally {
            close(conn, stmt, null);
        }
    }
}
