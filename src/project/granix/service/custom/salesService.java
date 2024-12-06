package service.custom;

import java.util.ArrayList;

import dto.salesdto;
import service.SuperService;

public interface salesService extends SuperService{
    String addsales(salesdto salesDto) throws Exception;
    String updatesales(salesdto salesDto) throws Exception;
    String deletesales(String id) throws Exception;
    salesdto getsales(String id) throws Exception;
    ArrayList<salesdto> getAllsales() throws Exception;
}
