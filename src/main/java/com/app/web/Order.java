/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.web;

/**
 *
 * @author Ruoyu
 */
public class Order {
    private int id;
    private int eid;
    private int mid;
    private String mtype;
    private String ecomment;
    private String date;
    private String entree;
    private String drink;

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getEcomment() {
        return ecomment;
    }

    public void setEcomment(String ecomment) {
        this.ecomment = ecomment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Order(int id, int eid, int mid, String mtype, String ecomment, String date) {
        this.id = id;
        this.eid = eid;
        this.mid = mid;
        this.mtype = mtype;
        this.ecomment = ecomment;
        this.date = date;
    }

    public Order(int eid, int mid, String mtype, String ecomment, String date) {
        this.eid = eid;
        this.mid = mid;
        this.mtype = mtype;
        this.ecomment = ecomment;
        this.date = date;
    }

    public Order(int eid, int mid, String mtype, String ecomment) {
        this.eid = eid;
        this.mid = mid;
        this.mtype = mtype;
        this.ecomment = ecomment;
    }
    
    //Temp Order
    public Order(int eid, int mid, String mtype, String ecomment, String date, String entree, String drink) {
        this.eid = eid;
        this.mid = mid;
        this.mtype = mtype;
        this.ecomment = ecomment;
        this.date = date;
        this.entree = entree;
        this.drink = drink;
    }

    public Order(int id, int eid, int mid, String mtype, String ecomment, String date, String entree, String drink) {
        this.id = id;
        this.eid = eid;
        this.mid = mid;
        this.mtype = mtype;
        this.ecomment = ecomment;
        this.date = date;
        this.entree = entree;
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", eid=" + eid + ", mid=" + mid + ", mtype=" + mtype + ", ecomment=" + ecomment + ", date=" + date + '}';
    }

    
    
    
}
