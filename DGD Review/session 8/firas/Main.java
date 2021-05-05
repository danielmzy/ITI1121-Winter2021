import elli.AnotherClass;
import elli.Person;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hi");
//
//        Pair<Integer, String> firstStudent = new Pair(12345, "Alex");
//        System.out.println(firstStudent.getValue());
//        System.out.println(firstStudent.getKey());
//
//        Pair<String, String> firstFruit = new Pair("apple", "red");
//        System.out.println(firstFruit.getValue());
//        System.out.println(firstFruit.getKey());
//
//        Pair<Person, Person> couple;

        String firstExpression = "7 3 2 - -";
        int result = PostFixSolver.solve(firstExpression);
        System.out.println(result);

        String secondExpression = "9 3 / 10 2 3 * - +";
        result = PostFixSolver.solve(secondExpression);
        System.out.println(result);
    }

}
