package controller;

import java.util.ArrayList;

import dto.warehouseDto;
import service.ServiceFactory;
import static service.ServiceFactory.ServiceType.WAREHOUSE;
import service.custom.warehouseService;

public class warehouseController {
    warehouseService warehouseService = (warehouseService) ServiceFactory.getInstance().getService(WAREHOUSE);
    
    public String addWarehouse(warehouseDto warehouseDto) throws Exception {
        return warehouseService.addWarehouse(warehouseDto);
    }
    public ArrayList<warehouseDto> getAllWarehouse() throws Exception {
        return warehouseService.getAllWarehouse();
    }

    public String updateWarehouse(warehouseDto warehouseDto) throws Exception {
        return warehouseService.updateWarehouse(warehouseDto);
    }

    public String deleteWarehouse(String id) throws Exception {
        return warehouseService.deleteWarehouse(id);
    }


    public warehouseDto getWarehouse(String id) throws Exception {
        return warehouseService.getWarehouse(id);
    }
}
