package controller;

import dto.buyerDto;
import service.ServiceFactory;
import service.custom.buyerService;
import static service.ServiceFactory.ServiceType.BUYER;;


public class buyerController {

    buyerService buyerService = (buyerService) ServiceFactory.getInstance().getService(BUYER);
    
    public String createAccount(buyerDto buyerDto) throws Exception {
        return buyerService.createAccount(buyerDto);
    }
}
