import java.util.Random;

public class SecurityAgency {
	
	public static void main(String[] args) {
		
		int maxAttempts = 300;
		
		Random random = new Random();
		SecurityAgent agent = new SecurityAgent();
		Combination c = null;
		boolean open = false;
		
		for (int i = 0; !open && i < maxAttempts; i++) {
			if (!agent.lock.activated) agent.activateDoorLock();
			
			int first = random.nextInt(5) + 1;
			int second = random.nextInt(5) + 1;
			int third = random.nextInt(5) + 1;
			c = new Combination(first, second, third);
			
			if (agent.lock.open(c)) open = true;
		}
		
		if (open) {
			System.out.println("Success!");
			System.out.println("The combination is: " + c);
		} else {
			System.out.println("Failed!");
			System.out.println("Reached the maximum number of attempts before finding the combination!");
		}
	}
}
