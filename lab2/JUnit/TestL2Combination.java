import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class TestL2Combination {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;


    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Combination (out of possible 3.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testEqualsForEqualCombinations() {

        Combination c1 = new Combination(1, 2, 3);
        Combination c2 = new Combination(1, 2, 3);
        boolean expected = true;
        boolean actual = c1.equals(c2);
        assertEquals("equals fails to return true for equal combinations", expected, actual);
        grade += 0.5;
    }

    @Test
    public void testEqualsForDifferentCombinations() {

        Combination c1 = new Combination(1, 2, 3);
        Combination c3 = new Combination(1, 1, 1);
        boolean expected = false;
        boolean actual = c1.equals(c3);
        assertEquals("equals fails to return false for different values of the combinations", expected, actual);
        grade += 0.5;
    }

    @Test
    public void testEqualsForUnorderedCombinations() {

      Combination c1 = new Combination(1, 2, 3);
      Combination c4 = new Combination(3, 2, 1);
      boolean expected = false;
      boolean actual = c4.equals(c1);
      assertEquals("Equal combinations need to have the values in the same order.", expected, actual);
      grade += 0.5;
    }

    @Test
    public void testEqualsForNullCombination() {

      Combination c1 = new Combination(1, 2, 3);
      Combination c5 = null;
      boolean expected = false;
      try{
        boolean actual = c1.equals(c5);
        assertEquals("Equals fails for null combination.", expected, actual);
        grade += 0.5;
      } catch(NullPointerException e){
        fail("equals does not check if the combination is not null.");
      } 
    }

    @Test
    public void testCombinationtoString() {

      Combination c1 = new Combination(1, 2, 3);
      String expected = "1:2:3";
      String actual = c1.toString();
      assertEquals("toString() incorrect format", expected, actual);
      grade += 1;
    }



    public static void main(String[] args) {

        TestUtils.runClass(TestL2Combination.class);

    }

}
