package dto;

public class warehouseDto {
    private String Warehouse_ID;
    private String Warehouse_name;
    private Double Max_Capacity;
    private String Location;
    private String Warehouse_Telephone;
    private String Sector;
    
    public warehouseDto() {
    }

    public warehouseDto(String Warehouse_ID, String Warehouse_name, Double Max_Capacity,String Location, String Warehouse_Telephone, String Sector) {
        
        this.Warehouse_ID = Warehouse_ID;
        this.Warehouse_name = Warehouse_name;
        this.Max_Capacity = Max_Capacity;
        this.Location = Location;
        this.Warehouse_Telephone = Warehouse_Telephone;
        this.Sector = Sector;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getWarehouse_ID() {
        return Warehouse_ID;
    }

    public void setWarehouse_ID(String warehouse_ID) {
        Warehouse_ID = warehouse_ID;
    }

    public String getWarehouse_name() {
        return Warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        Warehouse_name = warehouse_name;
    }

    public Double getMax_Capacity() {
        return Max_Capacity;
    }

    public void setMax_Capacity(Double max_Capacity) {
        Max_Capacity = max_Capacity;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getWarehouse_Telephone() {
        return Warehouse_Telephone;
    }

    public void setWarehouse_Telephone(String warehouse_Telephone) {
        Warehouse_Telephone = warehouse_Telephone;
    }

    @Override
    public String toString() {
        return "warehouseDto{" + "Warehouse_ID=" + Warehouse_ID + ", Warehouse_name=" + Warehouse_name + ", Max_Capacity="
                + Max_Capacity + ", Location=" + Location + ", Warehouse_Telephone=" + Warehouse_Telephone + ", Sector" +Sector+ "}";
    }

    
}
