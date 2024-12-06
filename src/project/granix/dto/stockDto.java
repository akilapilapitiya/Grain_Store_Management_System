package dto;

public class stockDto {
    private String Stock_ID;
    private String Stock_name;
    private Double Quantity;
    private Double PPU;
    private String Warehouse;
    
    public stockDto() {
    }

    public stockDto(String Stock_ID, String Stock_name, Double Quantity,Double PPU, String Warehouse) {
        
        this.Stock_ID = Stock_ID;
        this.Stock_name = Stock_name;
        this.Quantity = Quantity;
        this.PPU = PPU;
        this.Warehouse = Warehouse;
    }

    public String getStock_ID() {
        return Stock_ID;
    }

    public void setStock_ID(String stock_ID) {
        Stock_ID = stock_ID;
    }

    public String getStock_name() {
        return Stock_name;
    }

    public void setStock_name(String stock_name) {
        Stock_name = stock_name;
    }

    public Double getQuantity() {
        return Quantity;
    }

    public void setQuantity(Double quantity) {
        Quantity = quantity;
    }

    public Double getPPU() {
        return PPU;
    }

    public void setPPU(Double pPU) {
        PPU = pPU;
    }

    public String getWarehouse() {
        return Warehouse;
    }

    public void setWarehouse(String warehouse) {
        Warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "stockDto{"+"Stock_ID=" + Stock_ID + ", Stock_name=" + Stock_name + ", Quantity=" + Quantity + ", PPU="
                + PPU + ", Warehouse=" + Warehouse + "}";
    }

    
}
