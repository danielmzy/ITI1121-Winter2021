/** Minimalist tests for LinkedStack.
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class TestRoll {

    public static void main(String[] args) {

	StudentInfo.display();

	LinkedStack<String> s;

	s = new LinkedStack<String>();
	System.out.println(s);

	s.push("a"); 
	s.push("b"); 
	s.push("c"); 
	s.push("d"); 
	s.push("e"); 
 
	System.out.println(s); 
 
	s.roll(); 
	s.roll(); 
 
	System.out.println(s);	
    }
    
}
