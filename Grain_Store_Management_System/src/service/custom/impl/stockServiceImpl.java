package service.custom.impl;

import java.util.ArrayList;

import Entity.stockEntity;
import dao.DaoFactory;
import dto.stockDto;
import service.custom.stockService;
import dao.custom.stockDao;


public class stockServiceImpl implements stockService{
    stockDao stockDao = (stockDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.STOCK);

    @Override
    public String addStock(stockDto dto) throws Exception {
        stockEntity stockEntity = new stockEntity(dto.getStock_ID(), dto.getStock_name(), dto.getQuantity(), dto.getPPU(), dto.getWarehouse());
        
        if(stockDao.add(stockEntity)){
            return "successfully added";
        }else{
            return "fail";
        }
    }

    @Override
    public String updateStock(stockDto dto) throws Exception {
        stockEntity stockEntity = new stockEntity(dto.getStock_ID(), dto.getStock_name(), dto.getQuantity(), dto.getPPU(), dto.getWarehouse());
        
        if(stockDao.update(stockEntity)){
            return "successfully updated";
        }else{
            return "fail";
        }
    }

    

    @Override
    public stockDto getStock(String id) throws Exception {
        stockEntity entity = stockDao.get(id);
        return new stockDto(entity.getStock_ID(), entity.getStock_name(), entity.getQuantity(), entity.getPPU(), entity.getWarehouse());
    }

    @Override
    public ArrayList<stockDto> getAllStock() throws Exception {
        ArrayList<stockDto> stockDtos = new ArrayList<>();
        ArrayList<stockEntity> stockEntitys = stockDao.getAll();
        
        for (stockEntity entity : stockEntitys) {
            stockDto dto = new stockDto(entity.getStock_ID(), entity.getStock_name(), entity.getQuantity(), entity.getPPU(), entity.getWarehouse());
            stockDtos.add(dto);
        }
        return stockDtos;
    
    }

    @Override
    public String deleteStock(String id) throws Exception {
        if (stockDao.delete(id)) {
            return "Successfully Delete";
        } else {
            return "Fail";
        }
    }
}
