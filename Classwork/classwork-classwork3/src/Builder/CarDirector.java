package Builder;

public class CarDirector {

    private CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder){
        this.carBuilder=carBuilder;
    }

    public void build(){
        carBuilder.getCar();
    }
}
