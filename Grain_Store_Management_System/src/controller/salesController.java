package controller;

import java.util.ArrayList;

import dto.salesdto;
import service.ServiceFactory;
import service.custom.salesService;
import static service.ServiceFactory.ServiceType.SALES;


public class salesController {
    salesService salesService = (salesService) ServiceFactory.getInstance().getService(SALES);
    
    public String addsales(salesdto salesDto) throws Exception {
        return salesService.addsales(salesDto);
    }
    public ArrayList<salesdto> getAllsales() throws Exception {
        return salesService.getAllsales();
    }

    public String updatesales(salesdto salesDto) throws Exception {
        return salesService.updatesales(salesDto);
    }

    public String deletesales(String id) throws Exception {
        return salesService.deletesales(id);
    }

    public salesdto getsales(String id) throws Exception {
        return salesService.getsales(id);
    }
}
