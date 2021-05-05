package session_one;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void test(){
        Person person = new Person("Alex", 10);

        assertEquals("Alex",person.name);
        assertEquals(10,person.age);
    }

    @Test
    public void testReplace(){
        Person person = new Person("Alex", 10);

        person.replacePerson(person);

        assertEquals("Alex",person.name);
    }

    @Test
    public void testSetName(){
        Person person = new Person("Alex", 10);

        person.setPersonName(person, "Bob");

        assertEquals("Bob",person.name);
    }

}