package service.custom.impl;

import java.util.ArrayList;

import Entity.warehouseEntity;
import dao.DaoFactory;
import dao.custom.warehouseDao;
import dto.warehouseDto;
import service.custom.warehouseService;

public class warehouseServiceImpl implements warehouseService{

    warehouseDao warehouseDao = (warehouseDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.WAREHOUSE);

    @Override
    public String addWarehouse(warehouseDto dto) throws Exception {
        warehouseEntity warehouseEntity = new warehouseEntity(dto.getWarehouse_ID(), dto.getWarehouse_name(), dto.getMax_Capacity(), dto.getLocation(), dto.getWarehouse_Telephone(), dto.getSector());
        
        if(warehouseDao.add(warehouseEntity)){
            return "successfully added";
        }else{
            return "fail";
        }
    }

    @Override
    public String updateWarehouse(warehouseDto dto) throws Exception {
        warehouseEntity warehouseEntity = new warehouseEntity(dto.getWarehouse_ID(), dto.getWarehouse_name(), dto.getMax_Capacity(), dto.getLocation(), dto.getWarehouse_Telephone(),dto.getSector());
        
        if(warehouseDao.update(warehouseEntity)){
            return "successfully updated";
        }else{
            return "fail";
        }
    }

    

    @Override
    public warehouseDto getWarehouse(String id) throws Exception {
        warehouseEntity entity = warehouseDao.get(id);
        return new warehouseDto(entity.getWarehouse_ID(), entity.getWarehouse_name(), entity.getMax_Capacity(), entity.getLocation(), entity.getWarehouse_Telephone(),entity.getSector());
    }

    @Override
    public ArrayList<warehouseDto> getAllWarehouse() throws Exception {
        ArrayList<warehouseDto> warehouseDtos = new ArrayList<>();
        ArrayList<warehouseEntity> warehouseEntities = warehouseDao.getAll();
        
        for (warehouseEntity entity : warehouseEntities) {
            warehouseDto dto = new warehouseDto(entity.getWarehouse_ID(), entity.getWarehouse_name(), entity.getMax_Capacity(), entity.getLocation(), entity.getWarehouse_Telephone(),entity.getSector());
            warehouseDtos.add(dto);
        }
        return warehouseDtos;
    
    }

    @Override
    public String deleteWarehouse(String id) throws Exception {
        
        if (warehouseDao.delete(id)) {
            return "Successfully Delete";
        } else {
            return "Fail";
        }
    
    }
}
