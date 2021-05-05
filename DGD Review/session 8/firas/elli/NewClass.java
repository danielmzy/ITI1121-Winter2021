package elli;

public class NewClass {

    public int method(){
        AnotherClass anotherClass = new AnotherClass();

        return anotherClass.z;
    }

    public static void main(String[] args) {
        AnotherClass anotherClass = new AnotherClass();
        System.out.println(anotherClass.y);
        anotherClass.y += 5;
        System.out.println(anotherClass.y);

        AnotherClass anotherClass2 = new AnotherClass();
        System.out.println(anotherClass2.y);
    }
}
