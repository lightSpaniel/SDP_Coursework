package Bridge;


public class CentralLocking implements Product{

    private String description;

    public CentralLocking(String description){
        this.description=description;
    }

    public String getProductDescription(){
        return this.description;
    }



}
