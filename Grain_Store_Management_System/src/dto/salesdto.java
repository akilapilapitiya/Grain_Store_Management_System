package dto;

public class salesdto {
    
    private String Stock_ID;
    private String Buyer_ID;
    private Double Quantity_obtained;
    private String Warehouse_ID;

    public salesdto() {
    }

    public salesdto(String Stock_ID, String Buyer_ID, Double Quantity_obtained, String Warehouse_ID) {
        
        this.Stock_ID = Stock_ID;
        this.Buyer_ID = Buyer_ID;
        this.Quantity_obtained = Quantity_obtained;
        this.Warehouse_ID = Warehouse_ID;
        
    }

    public String getWarehouse_ID() {
        return Warehouse_ID;
    }

    public void setWarehouse_ID(String warehouse_ID) {
        Warehouse_ID = warehouse_ID;
    }

    public String getStock_ID() {
        return Stock_ID;
    }

    @Override
    public String toString() {
        return "salesdto{"+"Stock_ID=" + Stock_ID + ", Buyer_ID=" + Buyer_ID + ", Quantity_obtained=" + Quantity_obtained + ", Warehouse_ID" + Warehouse_ID
                + "}";
    }

    public void setStock_ID(String stock_ID) {
        Stock_ID = stock_ID;
    }

    public String getBuyer_ID() {
        return Buyer_ID;
    }

    public void setBuyer_ID(String buyer_ID) {
        Buyer_ID = buyer_ID;
    }

    public Double getQuantity_obtained() {
        return Quantity_obtained;
    }

    public void setQuantity_obtained(Double quantity_obtained) {
        Quantity_obtained = quantity_obtained;
    }

}
