package lab6;

public class Main {
    public static void main(String[] args) {
        Car one = new Car(30, 200, 100000, "Tesla Model S");
        Car two = new Car(30, 200, 100000, "Tesla Model S");
        System.out.println(one.equals(two));
        /*CarPark park = new CarPark(3);
        park.add(new SportCar(30, 200, 100000, "Tesla Model S"));
        park.add(new SUV(20, 150, 250000, "Hummer"));
        park.add(new Truck(100, 120, 500000, "MAN"));
        System.out.println(park);
        park.sort();
        System.out.println(park);
        park.findCar(150, 300);
        park.getCarParkPrice();*/
    }
}
