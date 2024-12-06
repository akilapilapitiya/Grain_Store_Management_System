package service.custom;

import java.util.ArrayList;

import dto.warehouseDto;
import service.SuperService;

public interface warehouseService extends SuperService{

    String addWarehouse(warehouseDto warehouseDto) throws Exception;
    String updateWarehouse(warehouseDto warehouseDto) throws Exception;
    String deleteWarehouse(String id) throws Exception;
    warehouseDto getWarehouse(String id) throws Exception;
    ArrayList<warehouseDto> getAllWarehouse() throws Exception;
}
