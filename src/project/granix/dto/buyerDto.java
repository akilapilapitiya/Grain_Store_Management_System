package dto;

public class buyerDto {
    private String Buyer_ID;
    private String Buyer_name;
    private String Buyer_Password;
    private String Buyer_Telephone;
    
    public buyerDto() {
    }

    public buyerDto(String Buyer_ID, String Buyer_name, String Buyer_Password, String Buyer_Telephone) {
        
        this.Buyer_ID = Buyer_ID;
        this.Buyer_name = Buyer_name;
        this.Buyer_Password = Buyer_Password;
        this.Buyer_Telephone = Buyer_Telephone;
    }

    public String getBuyer_ID() {
        return Buyer_ID;
    }

    public void setBuyer_ID(String buyer_ID) {
        Buyer_ID = buyer_ID;
    }

    public String getBuyer_name() {
        return Buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        Buyer_name = buyer_name;
    }

    public String getBuyer_Password() {
        return Buyer_Password;
    }

    public void setBuyer_Password(String buyer_Password) {
        Buyer_Password = buyer_Password;
    }

    public String getBuyer_Telephone() {
        return Buyer_Telephone;
    }

    public void setBuyer_Telephone(String buyer_Telephone) {
        Buyer_Telephone = buyer_Telephone;
    }

    @Override
    public String toString() {
        return "buyerDto{" + "Buyer_ID=" + Buyer_ID + ", Buyer_name=" + Buyer_name + ", Buyer_Password=" + Buyer_Password
                + ", Buyer_Telephone=" + Buyer_Telephone + "}";
    }

    

}
