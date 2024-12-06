package controller;

import java.util.ArrayList;

import dto.stockDto;
import service.ServiceFactory;
import static service.ServiceFactory.ServiceType.STOCK;
import service.custom.stockService;



public class stockController {
    stockService stockService = (stockService) ServiceFactory.getInstance().getService(STOCK);
    
    public String addStock(stockDto stockDto) throws Exception {
        return stockService.addStock(stockDto);
    }
    public ArrayList<stockDto> getAllStock() throws Exception {
        return stockService.getAllStock();
    }

    public String updateStock(stockDto stockDto) throws Exception {
        return stockService.updateStock(stockDto);
    }

    public String deleteStock(String id) throws Exception {
        return stockService.deleteStock(id);
    }

    public stockDto getStock(String id) throws Exception {
        return stockService.getStock(id);
    }
}
