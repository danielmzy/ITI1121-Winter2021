// Student name: Kian Zahrai
// Student number: 300098986
// Course code: ITI1121
// Lab section: B-01

public class SecurityAgent {

	// Instance (constant) variables.
	private final Combination combination; // remembers/stores a Combination
    private final DoorLock doorlock; // access toa DoorLock object thorugh reference

    // Constructor
    public SecurityAgent() {
    	combination = new Combination((int) (Math.random() * 5) + 1,
    		(int) (Math.random() * 5) + 1, (int) (Math.random() * 5) + 1); // new combination created and stored
    	doorlock = new DoorLock(combination); // new object of DoorLock created to save the above "new" Combination
    }

    public void activateDoorLock() {
    	doorlock.activate(combination);
    }

    public DoorLock getDoorLock() {
    	return doorlock;
    }

}