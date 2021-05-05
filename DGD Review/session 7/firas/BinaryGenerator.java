public class BinaryGenerator {

    // Method to generate binary numbers between 1 and `n` using the
    // queue data structure
    // n=7 => prints 1, 10, 11, 100, 101, 110, 111

    public static void generateBinary(int n){

        Queue<String> queue = new LinkedQueue<>();

        queue.enqueue("1");

        int i = 1;
        while (i <= n){

            String s;
            s = queue.dequeue();
            System.out.println(s);

            queue.enqueue(s+"0");
            queue.enqueue(s+"1");

            System.out.println(queue);

            i++;
        }

    }

}