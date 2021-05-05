public class Recursive {

    public static void main(String[] args) {

        recursivePrint(10);

        System.out.println(letterCount("back to school", 'o'));

    }

    public static void recursivePrint(int n){
        // stop condition
        if(n == 0){
            System.out.println(0);
        } else {
            recursivePrint(n-1);
            System.out.println(n);
        }
    }

    public static int letterCount(String s, char c){
        //System.out.println("letterCount: "+s);

        if(s.length() == 1){
            if(s.charAt(0) == c){
                return 1;
            } else {
                return 0;
            }
        } else if(s.length() == 0){
            return 0;
        } else {

            int half = s.length() / 2;
            String str1Part1;
            String str1Part2;
            int sum = 0;

            if(s.length()%2==1){
                str1Part1 = s.substring(0, half + 1);
                str1Part2 = s.substring(half + 1);
            } else {
                str1Part1 = s.substring(0, half);
                str1Part2 = s.substring(half);
            }
            sum = letterCount(str1Part1, c) + letterCount(str1Part2, c);
            return sum;
        }

    }
}
