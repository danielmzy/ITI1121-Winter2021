package session_two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SessionTwo {

    static int x = 0;

    public static void main(String[] args) {
        args.
//         SessionTwo s1 = new SessionTwo(); // x = 0
//         s1.x = 5;  // x = 5
//
//
//         SessionTwo s2 = new SessionTwo(); // x = 5
//        s2.x =6; // x = 6
//
//        System.out.println("s1.x: "+s1.x);
//        System.out.println("s2.x: "+s2.x);



//        System.out.println("n: "+243+" result: "+parityAnalysis(243));
//        System.out.println("n: "+12+" result: "+parityAnalysis(12));

        System.out.println("a: "+1+" b: "+3+" c: "+5+" result: "+equal(1, 3, 5));
        System.out.println("a: "+1+" b: "+1+" c: "+1+" result: "+equal(1, 1, 1));
        System.out.println("a: "+3+" b: "+1+" c: "+3+" result: "+equal(3, 1, 3));
    }

    // Create a function that takes three integer arguments (a, b, c)
    // and returns the amount of integers which are of equal value.

    static int equal(int a, int b, int c){
        // 1,3,5 => 0
        // 1,1,3 => 2
        // 1,1,1 => 3

        if(a == b && a == c && b == c){
            return 3;
        } else if ( a != b && a != c && b != c){
            return 0;
        } else {
            return 2;
        }
    }

    //parityAnalysis(243) ➞ true // 243 is odd and so is 9 (2 + 4 + 3)

    static boolean parityAnalysis(int n){
        // 243, 1000000000000

        int somme = 0;
        boolean nPair = n%2 == 0;

        while (n != 0){
            int x = n%10;
            //System.out.println("x: "+x);

            somme = somme + x;
            //System.out.println("somme: "+somme);

            n = n/10;
            //System.out.println("n: "+n);
        }

        boolean sommePair = somme%2 == 0;

        return nPair == sommePair;
        // nPair = true et sommePair = true *
        // nPair = true et sommePair = false
        // nPair = false et sommePair = true
        // nPair = false et sommePair = false *

    }
}

