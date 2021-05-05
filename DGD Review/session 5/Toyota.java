public class Toyota extends Car {
	// Toyota is A Car
	// but Car is not a Toyota
	public void honk(){
		System.out.println("The Toyota is Honking");
	}

	public static void main(String[] args) {
		// Toyota.honk();
		// Toyota newT = new Car(); // not correct why Car is not a Toyota
		// Car newT = new Toyota(); // correct
		// superclass variable = new subclass(); // correct
		// subclass variable = new superclass(); // wrong
		Vehicule newT; // declaring, save me some memory
		// {newT
		// 
		// }
		newT = new Car(); // creating, instanciating filling the memory
		// {newT
		// 	void honk()
		// }
		newT.honk();
	}
}
