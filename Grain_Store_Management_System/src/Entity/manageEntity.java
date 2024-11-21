package grain_store_management_system.Entity;

public class manageEntity {
    private String name;
    private double qty;
    private String brand;

    public manageEntity() {
    }

    public manageEntity(String name, double qty, String brand) {
        this.name = name;
        this.qty = qty;
        this.brand = brand;
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the qty
     */
    public double getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(double qty) {
        this.qty = qty;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "manageEntity{" + "name=" + name + ", qty=" + qty + ", brand=" + brand + '}';
    }
       
}
