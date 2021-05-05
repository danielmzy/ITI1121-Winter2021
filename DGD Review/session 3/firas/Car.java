class Car extends Vehicle {
    public String modelName = "Mustang";    // Car attribute

    public void honk() {                    // Vehicle method
        System.out.println("car, car!");
    }

    public void hit(Car other){
        System.out.println(this.brand + " " + this.modelName + " hit " + other.brand + " " + other.modelName);
    }
}