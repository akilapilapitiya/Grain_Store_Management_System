/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.custom.impl;

import Entity.userEntity;
import dao.DaoFactory;
import dao.custom.userDao;
import dto.userDto;

import service.custom.userService;



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



