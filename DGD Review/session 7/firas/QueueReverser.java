public class QueueReverser<E> {

    // Method to reverse a queue
    // 1, 2, 3, 4, 5 => 5, 4, 3, 2, 1
    public static <E> void reverseQueue(Queue<E> queue){

        Stack<E> stack = new LinkedStack<>();

        while (!queue.isEmpty()){
            stack.push(queue.dequeue());
        }

        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
    }
}
