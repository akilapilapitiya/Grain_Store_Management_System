package grain_store_management_system.Entity;


public class stockEntity {
    private String id;
    private String name;
    private String type;
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    

    public stockEntity(String id, String name,String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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

    

    @Override
    public String toString() {
        return "stockEntity{" + "id=" + id + ", name=" + name + ", type=" + type + '}';
    }
    
}
