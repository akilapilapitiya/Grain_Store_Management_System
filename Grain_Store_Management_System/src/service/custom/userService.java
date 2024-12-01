/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.custom;

import dto.userDto;
import service.SuperService;



/**
 *
 * @author ASUS
 */
public interface userService extends SuperService{
    String createAccount(userDto userDto) throws Exception;
}
