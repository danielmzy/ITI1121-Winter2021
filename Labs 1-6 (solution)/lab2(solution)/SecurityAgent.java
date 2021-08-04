public class SecurityAgent {
	
	Combination combo;
	DoorLock lock;
	
	public SecurityAgent() {
		combo = new Combination((int)(Math.random() * 5) + 1, (int)(Math.random() * 5) + 1, (int)(Math.random() * 5) + 1);
		lock = new DoorLock(combo);
	}
	
	public DoorLock getDoorLock() {
		return lock;
	}
	
	public void activateDoorLock() {
		lock.activate(combo);
	}
}
