package service.custom;

import dto.buyerDto;
import service.SuperService;

public interface buyerService extends SuperService{

    String createAccount(buyerDto userDto) throws Exception;
}
