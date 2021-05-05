class Person {
    private String name;
    private int age;
    private double budget;
    public Person(String name, int age, double budget) {
        super();
        this.name = name;
        this.age = age;
        this.budget = budget;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
}