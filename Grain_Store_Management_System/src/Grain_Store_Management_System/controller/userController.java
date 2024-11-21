/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grain_Store_Management_System.controller;


import Grain_Store_Management_System.dto.userDto;
import Grain_Store_Management_System.service.ServiceFactory;
import static Grain_Store_Management_System.service.ServiceFactory.ServiceType.EMPLOYEE;
import Grain_Store_Management_System.service.custom.userService;

/**
 *
 * @author ASUS
 */
public class userController {
    userService userService = (userService) ServiceFactory.getInstance().getService(EMPLOYEE);
    
    public String createAccount(userDto userDto) throws Exception {
        return userService.createAccount(userDto);
    }
}
