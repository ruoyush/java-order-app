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
public class Employee {
    private int id;
    private String name;
    private String email;
    private String pass;
    private int aid;
    private String department;

    public Employee(int id, String name, String email, String pass, int aid, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.aid = aid;
        this.department = department;
    }
    
    public Employee(int id, String name, String email, String pass, int aid) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.aid = aid;
    }

    public Employee(String name, String email, String pass, int aid, String department) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.aid = aid;
        this.department = department;
    }
    
    public Employee(int id, String name, String email, int aid, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.aid = aid;
        this.department = department;
    }
    
    
    public Employee(String name, String email, String pass, int aid) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.aid = aid;
    }
    
    public Employee() {

    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" + "id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", aid=" + aid + ", department= " + department +'}';
    }
    
}
