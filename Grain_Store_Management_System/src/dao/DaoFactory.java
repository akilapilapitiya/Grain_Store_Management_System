/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.custom.impl.userDaoImpl;


/**
 *
 * @author ASUS
 */
public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}
    
    public static DaoFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }
    
    public SuperDao getDao(DaoTypes type){
        switch (type) {
            
            case EMPLOYEE:
                return new userDaoImpl();   
            
            default:
                return null;
        }
    }

    
    public enum DaoTypes{
        //CUSTOMER, CAR, USER, CATEGORY
        EMPLOYEE
    }
}
