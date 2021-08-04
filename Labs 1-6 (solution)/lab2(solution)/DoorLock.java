
/*
Student name: Glen Wang
Student number: 300164126
Course: ITI 1121
Lab section: B-1
*/

/**
* The class Door lock
* @author Glen Wang
*/
public class DoorLock {
	
	// Constant.
	public static final int MAX_NUMBER_OF_ATTEMPTS = 3;
	
	// Instance variables.
	private Combination combination;
	private boolean open;
	private boolean activated;
	
	// hope this is allowed https://stackoverflow.com/questions/3918578
	private int numberOfAttempts = 0;
	
	/**
	*
	* Constructs a door lock
	*
	* @param combination  the combination
	*/
	public DoorLock(Combination combination) {
		
		this.combination = combination;
		activate(combination);
	}
	
	// Access methods.
	
	
	/**
	*
	* Gets whether the door is open
	*
	* @return boolean
	*/
	public boolean isOpen() {
		
		return open;
	}
	
	
	/**
	*
	* Gets whether the lock is active
	*
	* @return boolean
	*/
	public boolean isActivated() {
		
		return activated;
	}
	
	
	/**
	*
	* Attempts to open the door
	*
	* @param combination  the combination
	* @return boolean
	*/
	public boolean open(Combination combination) {
		
		if (!activated) return false;
		if (combination.equals(this.combination)) {
			open = true;
			numberOfAttempts = 0;
		} else {
			open = false;
			numberOfAttempts++;
			activated = numberOfAttempts < MAX_NUMBER_OF_ATTEMPTS;
			// System.out.printf("%d %d%n", numberOfAttempts, MAX_NUMBER_OF_ATTEMPTS);
		}
		return open;
	}
	
	
	/**
	*
	* Activates the lock
	*
	* @param c  the combination
	*/
	public void activate(Combination c) {
		
		if (!c.equals(combination)) return;
		activated = true;
		open = false;
		numberOfAttempts = 0;
	}
}
