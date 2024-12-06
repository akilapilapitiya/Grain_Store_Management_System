package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.salesEntity;
import dao.CrudUtil;
import dao.custom.salesDao;

public class salesDaoImpl implements salesDao{

    @Override
    public boolean add(salesEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO stock_obtain(Stock_ID, Buyer_ID, Quantity_obtained, Warehouse_ID) VALUES(?,?,?,?)", t.getStock_ID(),t.getBuyer_ID(),t.getQuantity_obtained(),t.getWarehouse_ID());
    }

    @Override
    public boolean update(salesEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE stock_obtain SET Stock_ID = ?, Quantity_obtained = ?,Warehouse_ID WHERE Buyer_ID = ?",t.getStock_ID(),t.getQuantity_obtained(),t.getWarehouse_ID(),t.getBuyer_ID());
    }


    @Override
    public salesEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT*FROM stock_obtain WHERE Buyer_ID = ?", id);
        
        while (rst.next()) {            
            salesEntity salesEntity = new salesEntity(rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getString(5)
                    );
            return salesEntity;
        }
        return null;
    }

    @Override
    public ArrayList<salesEntity> getAll() throws Exception {
        ArrayList<salesEntity> salesEntitys = new ArrayList<>();
        
        ResultSet rst = CrudUtil.executeQuery("SELECT*FROM stock_obtain");
        while (rst.next()) {            
            salesEntity salesEntity = new salesEntity(rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getString(5)
                   );
            salesEntitys.add(salesEntity);
        }
         return salesEntitys;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM stock_obtain WHERE Buyer_ID = ?",id);
    }
}
