/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grain_Store_Management_System.service;

import Grain_Store_Management_System.service.custom.impl.userServiceImpl;

/**
 *
 * @author ASUS
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){
        
    }
    public static ServiceFactory getInstance(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
            
        }
        return serviceFactory;
    }
    public SuperService getService(ServiceType type){
        switch(type){
            
            case EMPLOYEE:
                return new userServiceImpl();
            
            default:
                return null;
        }
    }

    
    public enum ServiceType{
        EMPLOYEE
    }
}
