package Bridge;


public class GearLocking implements Product{

    private String description;

    public GearLocking(String description){
        this.description=description;
    }

    public String getProductDescription(){
        return description;
    }



}
