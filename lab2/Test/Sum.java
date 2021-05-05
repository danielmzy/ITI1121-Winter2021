// Student name: Kian Zahrai
// Student number: 300098986
// Course code: ITI1121
// Lab section: B-01

  
public class Sum {
    public static void main( String[] args ) {

        int sum = 0;
        for ( int i = 0; i < args.length; i++ ) {
            sum += Integer.parseInt( args[ i ] );
        }
        System.out.println( "The sum is " + sum );

    }
}