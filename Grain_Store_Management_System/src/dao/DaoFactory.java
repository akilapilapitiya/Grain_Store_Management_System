/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.custom.impl.buyerDaoImpl;
import dao.custom.impl.salesDaoImpl;
import dao.custom.impl.stockDaoImpl;
import dao.custom.impl.userDaoImpl;
import dao.custom.impl.warehouseDaoImpl;


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
            case BUYER:
                return new buyerDaoImpl(); 
            case STOCK:
                return new stockDaoImpl();
            case WAREHOUSE:
                return new warehouseDaoImpl();
            case SALES:
                return new salesDaoImpl();
            default:
                return null;
        }
    }

    
    public enum DaoTypes{
        EMPLOYEE,BUYER,STOCK,WAREHOUSE,SALES
    }
}
