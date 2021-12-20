package lab6;

import java.util.Arrays;

public class CarPark {
    private Car[] carPark;
    private int size;

    public CarPark(int size) {
        this.carPark = new Car[size];
        this.size = 0;
    }

    public void sort() {
        Arrays.sort(carPark);
    }

    public void findCar(int A, int B) {
        Car[] r = new Car[size];
        int i = 0;
        for (Car car : carPark)
            if (car.getSpeed() >= A && car.getSpeed() <= B) r[i++] = car;
        for (Car res : r)
            if (res != null) System.out.println(res);
    }

    public void add(Car car) {
        try {
            carPark[size++] = car;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCarParkPrice() {
        int price = 0;
        for (Car car : carPark)
            price += car.getPrice();
        System.out.println(price);
    }

    @Override
    public String toString() {
        return Arrays.toString(carPark);
    }

}
