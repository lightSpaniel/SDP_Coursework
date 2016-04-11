package Builder;


public class SedanCarBuilder implements CarBuilder{


    private Car sedanCar;


    public Car getCar(){
        Car sedanCar = new Car("SEDAN");
        this.sedanCar = sedanCar;

        sedanCar.setBodyStyle("External dimensions: overall length (inches): 202.9,\n" +
                "overall width (inches): 76.2, overall height (inches): 60.7,\n" +
                "wheelbase (inches): 112.9, front track (inches): 65.3,\n" +
                "rear track (inches): 65.5 and curb to curb turning circle (feet): 39.5");

        sedanCar.setBreaks("Four-wheel disc brakes: two ventilated. Electronic brake distribution");
        sedanCar.setEngine("3.5L Duramax V 6 DOHC");
        sedanCar.setFuelType("Diesel 19 MPG city, 29 MPG highway, 23 MPG combined and 437 mi. range");
        sedanCar.setPower(" 285 hp @ 6,500 rpm; 253 ft lb of torque @ 4,000 rpm");
        sedanCar.setSeats("Front seat centre armrest.Rear seat centre armrest.Split-folding rear seats");
        sedanCar.setWindows("Laminated side windows.Fixed rear window with defroster");

        return this.sedanCar;
    }

}
