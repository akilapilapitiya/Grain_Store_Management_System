package grain_store_management_system.Entity;

public class userEntity {
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String password;

    public userEntity() {
    }

    public userEntity(String name, String email, String mobile, String password) {
        
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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

    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "userEntity{" + "id=" + id + ", name=" + name  + ", email=" + email + ", mobile=" + mobile + ", password=" + password + '}';
    }
}