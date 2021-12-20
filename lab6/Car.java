package lab6;

public class Car implements Comparable<Car>{
    private int fuelConsumption;
    private int speed;
    private int price;
    private String companyAndModel;

    public Car(int fuelConsumption, int speed, int price, String companyAndModel) {
        this.fuelConsumption = fuelConsumption;
        this.speed = speed;
        this.price = price;
        this.companyAndModel = companyAndModel;
    }

    public int getPrice() {
        return price;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Car: " + companyAndModel + ", price: " + price + "$, max speed: " + speed + "km/h, fuel consumption: "
                + fuelConsumption;
    }

    public int compareTo(Car t) {
        return Integer.compare(fuelConsumption, t.getFuelConsumption());
    }

}
