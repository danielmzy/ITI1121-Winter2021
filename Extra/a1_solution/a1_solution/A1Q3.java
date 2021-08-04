public class A1Q3 {

    private static int getLongestRun(int[] elems) {

        int length, start, run;

        length = 0;
        start = 0;
        run = 1;

        while (start < elems.length) {

            while (((start + run) < elems.length)
                    && elems[start] == elems[start + run]) {
                run++;
            }

            if (run > length) {
                length = run;
            }

            start = start + run;
            run = 1;

        }

        return length;
    }

    public static void main(String[] args) {

        int[] elems;
        elems = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            elems[i] = Integer.parseInt(args[i]);
        }

        System.out.println(getLongestRun(elems));

    }

}
