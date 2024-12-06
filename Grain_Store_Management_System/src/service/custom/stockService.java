package service.custom;

import java.util.ArrayList;

import dto.stockDto;
import service.SuperService;

public interface stockService extends SuperService{

    String addStock(stockDto stockDto) throws Exception;
    String updateStock(stockDto stockDto) throws Exception;
    String deleteStock(String id) throws Exception;
    stockDto getStock(String id) throws Exception;
    ArrayList<stockDto> getAllStock() throws Exception;
}
