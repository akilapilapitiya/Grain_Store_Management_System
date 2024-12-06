package dao.custom.impl;

import java.util.ArrayList;

import Entity.buyerEntity;
import dao.CrudUtil;
import dao.custom.buyerDao;

public class buyerDaoImpl implements buyerDao{

    @Override
    public boolean add(buyerEntity t) throws Exception {
    
    return CrudUtil.executeUpdate("INSERT INTO BUYER (Buyer_ID, Buyer_name, Buyer_Password, Buyer_Telephone) VALUES (?, ?, ?, ?)", t.getBuyer_ID(), t.getBuyer_name(),t.getBuyer_Password(),t.getBuyer_Telephone());    }
    
    @Override
    public boolean update(buyerEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public buyerEntity get(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<buyerEntity> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
