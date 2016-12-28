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
public class Menu {

    private int id;
    private String entree;
    private String drink;
    private String day;
    private String month;
    private String year;
    private String date = year+"-"+month+"-"+day;
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Menu(int id, String entree, String drink, String date) {
        this.id = id;
        this.entree = entree;
        this.drink = drink;
        this.date = date;
    }
    
    public Menu(String entree, String drink, String date) {
        this.entree = entree;
        this.drink = drink;
        this.date = date;
    }
 
    
    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", entree=" + entree + ", drink=" + drink + ", day=" + day + ", month=" + month + ", year=" + year + ", date=" + date + '}';
    }

    
}
