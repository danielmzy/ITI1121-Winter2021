public class Main {
    public static void main(String[] args) {

        // Create a myCar object


        // Call the honk() method (from the Vehicle class) on the myCar object
        //myCar.honk();

        // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
        //System.out.println(myCar.brand + " " + myCar.modelName);
//
//        Motocycle motocycle = new Motocycle();
//        motocycle.honk();
//        System.out.println(motocycle.brand + " " + motocycle.modelName);

//        Car myCar = new Car();
//
//        Car yourCar = new Car();
//        // brand: Ford
//        // modelName: Mustang
//
//        yourCar.brand = "Mercedes";
//        yourCar.modelName = "x123";
//        // brand: Mercedes
//        // modelName: x123
//
//        myCar.hit(yourCar);
//        yourCar.hit(myCar);

//        Shiritori shiritori = new Shiritori(20);
//        System.out.println(shiritori.play("hello"));
//        System.out.println(shiritori.play("okay"));
//        shiritori.restart();
//        System.out.println(shiritori.play("okay"));
//        System.out.println(shiritori.play("no"));

        Person[] people = {
                new Person("Alex", 20, 1000),
                new Person("Bob", 25, 500),
                new Person("Carl", 27, 2000)
        };

        System.out.println(BudgetCalculator.getBudgets(people));
    }
}