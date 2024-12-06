/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dto.userDto;
import service.ServiceFactory;
import static service.ServiceFactory.ServiceType.EMPLOYEE;
import service.custom.userService;





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
