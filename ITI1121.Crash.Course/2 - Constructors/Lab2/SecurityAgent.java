import java.util.Random;
// https://docs.oracle.com/javase/8/docs/api/java/util/Random.html

public class SecurityAgent {
	
	public Combination combo;
	public DoorLock lock;
	
	public SecurityAgent() {
		Random random = new Random();
		int first = random.nextInt(5) + 1;
		int second = random.nextInt(5) + 1;
		int third = random.nextInt(5) + 1;
		combo = new Combination(first, second, third);
		lock = new DoorLock(combo);
	}
	
	public void activateDoorLock() {
		lock.activate(combo);
	}
}
