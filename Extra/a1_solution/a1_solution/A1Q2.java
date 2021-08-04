public class A1Q2 {

    private static boolean hasTwoLengthRun(int[] elems) {

        boolean found;
        found = false;

        if (elems.length >= 2) {

            int position = 0;

            while (!found && position < elems.length - 1) {
                if (elems[position] == elems[position + 1]) {
                    found = true;
                }
                position++;
            }
        }

        return found;
    }

    public static void main(String[] args) {

        int[] elems;
        elems = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            elems[i] = Integer.parseInt(args[i]);
        }

        System.out.println(hasTwoLengthRun(elems));

    }

}
