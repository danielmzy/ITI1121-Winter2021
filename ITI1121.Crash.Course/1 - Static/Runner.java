class Runner {
	
	public static void main(String[] args) {
		
		Pikachu[] pikachus = new Pikachu[10];
		
		for (int i = 0; i < pikachus.length; i++) {
			pikachus[i] = new Pikachu();
		}
		
		// even though different ones are attacking, they'll
		// all increase the same static attackCount
		pikachus[1].attack();
		pikachus[0].attack();
		pikachus[2].attack();
		pikachus[5].attack();
		
		// static members are accessed from the class, not an object of that class!
		// syntax is Class.staticMember
		System.out.print("The pikachus have attacked " + Pikachu.attackCount + " times.");
	}
}
