public class Toyota2<T extends Vehicule>{
// public abstract class Toyota2<T extends Vehicule>{
	// Toyota2 t; // works
	// t = new Toyota2(); // no
	
	T a;
	public Toyota2(T a) {
		this.a = a;
	}

	// public abstract void honk();
	public void honk() {
		a.honk();
	}

	public static void main(String[] args) {
		Toyota2<Car> t = new Toyota2<Car>(new Car());
		Toyota2<Toyota> t2 = new Toyota2<Toyota>(new Toyota());
		t.honk();
		t2.honk();
	}
}

