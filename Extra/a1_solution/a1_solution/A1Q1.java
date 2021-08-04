public class A1Q1 {

    private static int countPositive(int[] elems) {

        int count;
        count = 0;

        for (int i = 0; i < elems.length; i++) {
            if (elems[i] > 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] elems;
        elems = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            elems[i] = Integer.parseInt(args[i]);
        }

        System.out.println(countPositive(elems));

    }

}
