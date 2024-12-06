package service.custom.impl;

import Entity.buyerEntity;
import dao.DaoFactory;
import dao.custom.buyerDao;
import dto.buyerDto;
import service.custom.buyerService;

public class buyerServiceImpl implements buyerService{

    buyerDao buyerDao = (buyerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BUYER);

    @Override
    public String createAccount(buyerDto dto) throws Exception {
        buyerEntity buyerEntity = new buyerEntity(dto.getBuyer_ID(),  dto.getBuyer_name(), dto.getBuyer_Password(),dto.getBuyer_Telephone());
        
        if(buyerDao.add(buyerEntity)){
            return "successfully added";
        }else{
            return "fail";
        }
    }
}
