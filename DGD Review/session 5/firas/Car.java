public class Car {
    private String brand;
    private String model;
    private int year;

    public Car (String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public boolean equals(Object other) {
        if(other == null || !(other instanceof Car)){
            return false;
        }

        Car otherCar = (Car) other;

        if(this.brand.equals(otherCar.brand) && this.model.equals(otherCar.model) && this.year == otherCar.year){
            return true;
        } else {
            return false;
        }

    }
}