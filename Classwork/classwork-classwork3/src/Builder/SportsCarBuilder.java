package Builder;

public class SportsCarBuilder  implements CarBuilder{


    private Car sportsCar;


        public Car getCar(){
            Car sportsCar = new Car("SPORTS");
            this.sportsCar = sportsCar;

            sportsCar.setBodyStyle("External dimensions: overall length (inches): 192.3,\n" +
                    "overall width (inches): 75.5, overall height (inches): 54.2,\n" +
                    "wheelbase (inches): 112.3, front track (inches): 63.7,\n" +
                    "rear track (inches): 64.1 and curb to curb turning circle (feet): 37.7");
            sportsCar.setBreaks("Four-wheel disc brakes: two ventilated. Electronic brake distribution.");
            sportsCar.setEngine("3.6L V 6 DOHC and variable valve timing");
            sportsCar.setFuelType("Petrol 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range");
            sportsCar.setPower("323 hp @ 6,800 rpm; 278 ft lb of torque @ 4,800 rpm");
            sportsCar.setSeats("Driver sports front seat with one power adjustments manual height,\n" +
                    "front passenger seat sports front seat with one power adjustments");
            sportsCar.setWindows("Front windows with one-touch on two windows");

            return this.sportsCar;
        }
}
