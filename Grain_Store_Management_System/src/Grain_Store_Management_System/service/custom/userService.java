/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Grain_Store_Management_System.service.custom;

import Grain_Store_Management_System.dto.userDto;
import Grain_Store_Management_System.service.SuperService;

/**
 *
 * @author ASUS
 */
public interface userService extends SuperService{
    String createAccount(userDto userDto) throws Exception;
}
