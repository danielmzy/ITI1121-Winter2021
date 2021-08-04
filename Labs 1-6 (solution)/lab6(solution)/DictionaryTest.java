import java.util.NoSuchElementException;
import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Some tests for Dictionary...
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */
public class DictionaryTest {

    @Test
    public void testGetX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        assertEquals(1, (int) dict.get("X"));
    }

    @Test
    public void testGetY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        assertEquals(2, (int) dict.get("Y"));
    }

    @Test
    public void testGetZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test
    public void testGetXX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("X", 4);
        assertEquals(4, (int) dict.get("X"));
    }

    @Test
    public void testGetYY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Y", 4);
        assertEquals(4, (int) dict.get("Y"));
    }

    @Test
    public void testGetZZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Z", 4);
        assertEquals(4, (int) dict.get("Z"));
    }

    @Test
    public void testContainsEmpty() {
        Dictionary dict = new Dictionary();
        assertFalse(dict.contains("X"));
    }

    @Test
    public void testContainsNotFound() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        assertFalse(dict.contains("W"));
    }

    @Test
    public void testContainsX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        assertTrue(dict.contains("X"));
    }

    @Test
    public void testContainsY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        assertTrue(dict.contains("Y"));
    }

    @Test
    public void testContainsZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        assertTrue(dict.contains("Z"));
    }

    @Test
    public void testContainsXX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("X", 4);
        assertTrue(dict.contains("X"));
    }

    @Test
    public void testContainsYY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Y", 4);
        assertTrue(dict.contains("Y"));
    }

    @Test
    public void testContainsZZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Z", 4);
        assertTrue(dict.contains("Z"));
    }

    @Test
    public void testPutDyncamicArray() {
        Dictionary dict = new Dictionary();
        for (int i = 0; i < 1000; i++) {
            dict.put("X" + i, i);
        }
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, (int) dict.get("X" + i));
        }
    }

    @Test
    public void testReplaceX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.replace("X", 4);
        assertEquals(4, (int) dict.get("X"));
    }

    @Test
    public void testReplaceY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.replace("Y", 4);
        assertEquals(4, (int) dict.get("Y"));
    }

    @Test
    public void testReplaceZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.replace("Z", 4);
        assertEquals(4, (int) dict.get("Z"));
    }

    @Test
    public void testReplaceXX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("X", 4);
        dict.replace("X", 5);
        assertEquals(5, (int) dict.get("X"));
    }

    @Test
    public void testReplaceYY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Y", 4);
        dict.replace("Y", 5);
        assertEquals(5, (int) dict.get("Y"));
    }

    @Test
    public void testReplaceZZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Z", 4);
        dict.replace("Z", 5);
        assertEquals(5, (int) dict.get("Z"));
    }

    @Test
    public void testRemoveX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.remove("X");
        assertFalse(dict.contains("X"));
        assertEquals(2, (int) dict.get("Y"));
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test
    public void testRemoveY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.remove("Y");
        assertFalse(dict.contains("Y"));
        assertEquals(1, (int) dict.get("X"));
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test
    public void testRemoveZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.remove("Z");
        assertFalse(dict.contains("Z"));
        assertEquals(1, (int) dict.get("X"));
        assertEquals(2, (int) dict.get("Y"));
    }

    @Test
    public void testRemoveXX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("X", 4);
        dict.remove("X");
        assertEquals(1, (int) dict.get("X"));
        assertEquals(2, (int) dict.get("Y"));
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test
    public void testRemoveYY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Y", 4);
        dict.remove("Y");
        assertEquals(1, (int) dict.get("X"));
        assertEquals(2, (int) dict.get("Y"));
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test
    public void testRemoveZZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Z", 4);
        dict.remove("Z");
        assertEquals(1, (int) dict.get("X"));
        assertEquals(2, (int) dict.get("Y"));
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test
    public void testGetStatic() {
        Dictionary d1 = new Dictionary();
        Dictionary d2 = new Dictionary();
        d1.put("X", 1);
        assertFalse(d2.contains("X"));
    }

    	public static void main(String[] args) {

        Result result = JUnitCore.runClasses(DictionaryTest.class);
        System.out.println();

        System.out.println("List of failed tests:");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println();

        System.out.print("Passed all the tests (true/false): ");
        System.out.println(result.wasSuccessful());
    }

}
