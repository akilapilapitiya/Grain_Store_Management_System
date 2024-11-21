package Entity;

public class ItemEntity {
    private String id;
    private String name;
    
    public ItemEntity(String id, String name) {
        this.id = id;
        this.name = name;
        
    }
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemEntity{" + "id=" + id + ", name=" + name +  '}';
    }
}
