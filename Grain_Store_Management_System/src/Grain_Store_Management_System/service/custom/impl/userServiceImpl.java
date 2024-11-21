/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grain_Store_Management_System.service.custom.impl;

import Grain_Store_Management_System.Entity.userEntity;
import Grain_Store_Management_System.dao.DaoFactory;
import Grain_Store_Management_System.dao.custom.userDao;
import Grain_Store_Management_System.dto.userDto;
import Grain_Store_Management_System.service.custom.userService;


/**
 *
 * @author ASUS
 */
public class userServiceImpl implements userService{
    userDao userDao = (userDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.EMPLOYEE);

    @Override
    public String createAccount(userDto dto) throws Exception {
        userEntity userEntity = new userEntity(dto.getEmployee_ID(),  dto.getFirst_name(), dto.getSecond_name(), dto.getUser_Password());
        
        if(userDao.add(userEntity)){
            return "successfully added";
        }else{
            return "fail";
        }
    }
}
