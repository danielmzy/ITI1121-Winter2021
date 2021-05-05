public class Main {
    public static void main(String[] args) {
        String brand1 = "brand1";
        String brand2 = "brand1";
        Car Car1 = new Car(brand1, "title", 2020);
        Car Car2 = new Car(brand2, "title", 2020);

        System.out.println(Car1.equals(Car2));

        CarComparator CarComparator = new CarComparator();
        System.out.println(CarComparator.compare(Car1,Car2));

    }
}
