import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;
import java.awt.event.ActionEvent;

import static org.junit.Assert.*;

public class TestL10OrderedList {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @Before
    public void setUp() {

    }

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for OrderedStructure (out of a possible 10.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testConstructor() {

        OrderedList list = new OrderedList();

        assertEquals("The empty list shoud have size 0", 0, list.size());

        grade += 0.5;
    }

    @Test
    public void testGetNegative() {

        OrderedList list = new OrderedList();

        try {
            list.get(-1);
            fail("list.get(-1) was expected to throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void testGetIndexOutOfBoundsException() {

        OrderedList list = new OrderedList();

        try {
            list.get(1);
            fail("list.get(1) on empty list was expected to throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void testAddExceptions() {

        OrderedList list = new OrderedList();

        try {
            list.add(null);
            fail("list.add(null) was expected to throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            grade += 0.5;
        } catch (NullPointerException e) { // Acceptable
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void testRemoveNegative() {

        OrderedList list = new OrderedList();

        try {
            list.remove(-1);
            fail("list.remove(-1) was expected to throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void testRemoveIndexOutOfBoundsException() {

        OrderedList list = new OrderedList();

        try {
            list.remove(1);
            fail("list.get(1) on empty list was expected to throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void testAddAlreadySorted() {
        try {
            OrderedList list = new OrderedList();

            list.add("A");
            list.add("B");

            assertEquals("List with two elements expected to have size 2", 2, list.size());
            grade += 0.5;

            assertEquals("Incorrect first element of the list", "A", list.get(0));
            assertEquals("Incorrect second element of the list", "B", list.get(1));
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void testAddNeedsSorting() {
        try {
            OrderedList list = new OrderedList();

            list.add("C");
            list.add("A");
            list.add("B");

            assertEquals("Incorrect first element of the list", "A", list.get(0));
            grade += 0.5;

            assertEquals("Incorrect second element of the list", "B", list.get(1));
            grade += 0.5;

            assertEquals("Incorrect third element of the list", "C", list.get(2));
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testRemoveLast() {
        try {
            OrderedList list = new OrderedList();

            list.add("A");
            list.add("B");

            list.remove(1);

            assertEquals("Size after an element removal should decrease", 1, list.size());
            grade += 0.5;

            assertEquals("Incorrect first element after removing the second element of the list", "A", list.get(0));
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testRemoveFirst() {
        try{
            OrderedList list = new OrderedList();

            list.add("A");
            list.add("B");

            list.remove(0);

            assertEquals("Incorrect first element of the list after the removal of the old first element", "B", list.get(0));
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testMerge() {
        try{
            OrderedList list1 = new OrderedList();
            OrderedList list2 = new OrderedList();

            list1.add("C");
            list1.add("A");

            list2.add("D");
            list2.add("B");

            list1.merge(list2);

            assertEquals("Incorrect size of the list after merging list", 4, list1.size());
            grade += 0.5;

            assertEquals("The merged list should not change size", 2, list2.size());
            grade += 0.5;

            assertEquals("First element in the ordered list after merging (should be from the first list)", "A", list1.get(0));
            grade += 0.5;

            assertEquals("Second element in the ordered list after merging (should be from the merged list)", "B", list1.get(1));
            grade += 0.5;

            assertEquals("Third element in the ordered list after merging (should be from the first list)", "C", list1.get(2));
            grade += 0.5;

            assertEquals("Forth element in the ordered list after merging (should be from the merged list)", "D", list1.get(3));
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL10OrderedList.class);

    }

}
