public class DoorLock {
	
	public Combination combination;
	public boolean activated;
	public int numberOfAttempts = 0;
	
	public DoorLock(Combination combination) {
		this.combination = combination;
		activate(combination);
	}
	
	public boolean open(Combination combination) {
		if (!activated) return false;
		if (combination.equals(this.combination)) {
			numberOfAttempts = 0;
			return true;
		} else {
			numberOfAttempts++;
			activated = numberOfAttempts < 3;
			return false;
		}
	}
	
	public void activate(Combination c) {
		if (!c.equals(combination)) return;
		activated = true;
		numberOfAttempts = 0;
	}
}
