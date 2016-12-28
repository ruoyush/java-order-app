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
public class MenuUtil {
  private DataSource dataSource;
  
        public MenuUtil(DataSource theDataSource){
            dataSource = theDataSource;
        }
    
       public List<Menu> getMenus() throws Exception{
		List<Menu> menus = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
        
        try{
            conn = dataSource.getConnection();
            String sql = "select id, entree, drink, date from menus order by date";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {

                int id = rs.getInt("id");
                String entree = rs.getString("entree");
                String drink = rs.getString("drink");
                String date = rs.getString("date");

                Menu tempM = new Menu(id, entree, drink, date);

                menus.add(tempM);

            }
            return menus;       
            
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

    public Menu getMenu(String theMenuId) throws Exception{
        Menu theMenu = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int menuId;

        try {
            menuId = Integer.parseInt(theMenuId);
            conn = dataSource.getConnection();
            String sql = "select id, entree, drink, date from Menus where id=" + menuId + "";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                int id = rs.getInt("id");
                String entree = rs.getString("entree");
                String drink = rs.getString("drink");
                String date = rs.getString("date");

                theMenu = new Menu(menuId, entree, drink, date);

            }else{
                throw new Exception("Could not find Menu ID: "+ menuId);
            }
            return theMenu;

        } finally {
            close(conn, stmt, rs);
        }
    }
    
    public void addMenu(Menu theMenu) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        String entree = theMenu.getEntree();
        String drink = theMenu.getDrink();
        String date = theMenu.getDate();

        try {
            conn = dataSource.getConnection();
            String sql = "insert into Menus (entree,drink,date) values('" + entree + "','" + drink + "','" + date + "\')";
            stmt = conn.prepareStatement(sql);

            stmt.execute();

        } finally {
            close(conn, stmt, null);
        }

    }
    
    public void updateMenu(Menu theMenu) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        String entree = theMenu.getEntree();
        String drink = theMenu.getDrink();
        String date = theMenu.getDate();
        int id = theMenu.getId();

        try {
            conn = dataSource.getConnection();
            String sql = "update menus set entree="+"'"+entree+"', drink='"+drink+"', date='"+date+"' where id="+id+"";
            stmt = conn.prepareStatement(sql);

            stmt.execute();

        } finally {
            close(conn, stmt, null);
        }
    }

    public void deleteMenu(String theMenuId) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;

        int id = Integer.parseInt(theMenuId);

        try {
            conn = dataSource.getConnection();
            String sql = "delete from menus where id=" + id + "";
            stmt = conn.prepareStatement(sql);

            stmt.execute();

        } finally {
            close(conn, stmt, null);
        }
    }
}
