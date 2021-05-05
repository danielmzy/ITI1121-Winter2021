public class Car extends Vehicle {
	// 0..1 superclass 
	// 0..* interfaces 

	public void honk(){
		System.out.println("car");
	}

	public static void honk(int i){
		System.out.println("car "+i);
	}

	public static void main(String[] args) {
		Car c = new Car();
		c.honk();
		Car.honk(0);
	}
}
