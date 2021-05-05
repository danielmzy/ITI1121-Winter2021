public class UniquifiableLinkedQueue<E> extends LinkedQueue<E> {

    public Queue<E> uniquify() {
    	// Add your code here
        String items = "";
        int countBot = 0; 
        while (!isEmpty()) {
            items += dequeue() + ",";
            countBot++;
        }
        Queue<E> toBeRetured = new LinkedQueue<>();
        String temporary = "";
        for (int x = 0; x < countBot; x++) {
            String itemCurrent = items.split(",")[x];
            E item = (E) itemCurrent;
            enqueue(item);

            if (x == 0) {
                temporary = itemCurrent;
                E toAdd = (E) itemCurrent;
                toBeRetured.enqueue(toAdd);

            }
            if (x != 0) {
                if (!itemCurrent.equals(temporary)) {
                    E toAdd = (E) itemCurrent;
                    toBeRetured.enqueue(toAdd);
                }
                temporary = itemCurrent;
            }

        }

        return toBeRetured;
        //throw new UnsupportedOperationException( "not implemented yet!" );
    }

}