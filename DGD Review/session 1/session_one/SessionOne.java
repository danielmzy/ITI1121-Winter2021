package session_one;

public class SessionOne {
    public static void main(String[] args) {
        Person person = new Person("Alex", 10); // 01 -> 22 -> Alex
        person.presentYourSelf();

        Person.replacePerson(person); // 22
        person.presentYourSelf(); // 01 -> 22

        Person.setPersonName(person, "Bob");// 22
        person.presentYourSelf();

        person = Person.returnNewPerson(); // 01 -> 23 -> Carl
        person.presentYourSelf();
    }
}

