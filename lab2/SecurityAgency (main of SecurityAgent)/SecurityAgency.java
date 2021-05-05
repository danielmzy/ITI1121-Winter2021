public class SecurityAgency {

    public static void main(final String[] args) {

        final int maxAttempts = (int) (Math.random() * 500);

        // Creates a new security agent called bob!
        final SecurityAgent bob = new SecurityAgent();

        // Ask bob to give us access to the door lock
        final DoorLock aLock = bob.getDoorLock();

        // Let's find bob's secret combination
        Combination c = null;
        boolean open = false;
        int iter = 0;

        while (!open) {

            // bob knows the combination and will
            // re-activate the DoorLock

            if (!aLock.isActivated()) {
                bob.activateDoorLock();
            }

            // let's create a new random combination

            final int first = (int) (Math.random() * 5) + 1;
            final int second = (int) (Math.random() * 5) + 1;
            final int third = (int) (Math.random() * 5) + 1;

            c = new Combination(first, second, third);

            // if this combination opens the lock
            // we're done.
            if (aLock.open(c)) {
                open = true;
            }

            iter++;
        }
        System.out.println("% java SecurityAgency " + maxAttempts);
        System.out.println("Success!");
        System.out.println("Number of attemtps: " + iter);
        System.out.println("The combination is: " + c);
    }
}