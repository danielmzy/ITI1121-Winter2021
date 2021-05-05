package session_one;

public class Person {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void presentYourSelf(){
        System.out.println("My name is "+ this.name+" and I am "+this.age+" years old.");
    }

    public static void setPersonName(Person personToRename, String newName) {// 05 -> 22
        personToRename.name = newName; // 22.name = newName
    }

    public static void replacePerson(Person personToReplace) { // 03 -> 22
        Person newPerson = new Person("Carl", 20); // 04 -> 23
        personToReplace = newPerson; // 03 -> 23 and 01 is still 22
    }

    public static Person returnNewPerson() {
        return new Person("Carl", 20); // 25
    }
}