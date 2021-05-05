public class BudgetCalculator {
    static int getBudgets(Person[] people){
        int sum = 0;
        for(Person person : people){
            sum += person.getBudget();
        }
        return sum;
    }
}
