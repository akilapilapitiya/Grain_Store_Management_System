package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.stockEntity;
import dao.CrudUtil;
import dao.custom.stockDao;

public class stockDaoImpl implements stockDao{

    @Override
    public boolean add(stockEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO stock VALUES(?,?,?,?,?)", t.getStock_ID(),t.getStock_name(),t.getQuantity(),t.getPPU(),t.getWarehouse());
    }

    @Override
    public boolean update(stockEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE stock SET Stock_name = ?, Quantity = ?, PPU = ?, Warehouse = ? WHERE Stock_ID = ?",t.getStock_name(),t.getQuantity(),t.getPPU(),t.getWarehouse(),t.getStock_ID());
    }


    @Override
    public stockEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT*FROM stock WHERE Stock_ID = ?", id);
        
        while (rst.next()) {            
            stockEntity stockEntity = new stockEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getDouble(4),
                    rst.getString(5));
            return stockEntity;
        }
        return null;
    }

    @Override
    public ArrayList<stockEntity> getAll() throws Exception {
        ArrayList<stockEntity> stockEntitys = new ArrayList<>();
        
        ResultSet rst = CrudUtil.executeQuery("SELECT*FROM stock");
        while (rst.next()) {            
            stockEntity stockEntity = new stockEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getDouble(4),
                    rst.getString(5));
            stockEntitys.add(stockEntity);
        }
         return stockEntitys;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM stock WHERE Stock_ID = ?",id);
    }

}
