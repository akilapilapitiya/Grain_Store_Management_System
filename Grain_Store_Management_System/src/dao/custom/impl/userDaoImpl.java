/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.custom.impl;


import Entity.userEntity;
import dao.CrudUtil;
import dao.custom.userDao;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class userDaoImpl implements userDao{
    @Override
    public boolean add(userEntity t) throws Exception {
    
    return CrudUtil.executeUpdate("INSERT INTO employee(Employee_ID, First_name, Second_name, User_Password) VALUES(?,?,?,?)", t.getEmployee_ID(), t.getFirst_name(),t.getSecond_name(),t.getUser_Password());    }
    
    @Override
    public boolean update(userEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public userEntity get(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<userEntity> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
