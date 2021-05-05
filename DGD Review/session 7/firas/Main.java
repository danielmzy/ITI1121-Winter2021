public class Main {

    public static void main(String[] args) {
        Queue<String> stringQueue = new LinkedQueue<>();
        //stringQueue.enqueue(null);
        stringQueue.enqueue("A");
        stringQueue.enqueue("B");
        stringQueue.enqueue("C");

        System.out.println(stringQueue);

        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.peek());

        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue);

        Queue<Integer> integerQueue = new LinkedQueue<>();
        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        integerQueue.enqueue(3);
        integerQueue.enqueue(4);
        integerQueue.enqueue(5);
        System.out.println(integerQueue);

        QueueReverser.reverseQueue(integerQueue);
        System.out.println(integerQueue);


        BinaryGenerator.generateBinary(5);
    }
}
