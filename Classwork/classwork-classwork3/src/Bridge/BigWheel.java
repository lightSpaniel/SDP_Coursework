package Bridge;

public class BigWheel implements Car{

    private Product product;
    private String carDescription;

    public BigWheel(Product product, String carDescription){
        this.carDescription=carDescription;
        this.product=product;
    }

    public String produceProduct(){
        return "Producing " + product.getProductDescription()+"\n"+
                "Modifying product " + product.getProductDescription() + " according to " + carDescription;
    }

    public String assemble(){
        return "Assembling " + product.getProductDescription() + " for " + carDescription;
    }
    public void printDetails(){
        System.out.println(produceProduct());
        System.out.println(assemble());
        System.out.println("Car: "+carDescription + ", Product:"+product.getProductDescription()+"\n");
    }

}
