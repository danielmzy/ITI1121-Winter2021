import java.io.*;

public class LinkedStack<E> implements Stack<E>, Serializable {

    private static class Elem<T> implements Serializable{
        private T info;
        private Elem<T> next;
        private Elem( T info, Elem<T> next) {
            this.info = info;
            this.next = next;
        }
    }

    private Elem<E> top; // instance variable

    public LinkedStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push( E info ) {

        if(info == null)
            throw new NullPointerException("Cannot stack a null object");

        top = new Elem<E>( info, top );
    }

    public E peek() {
        if (isEmpty())
            throw new EmptyStackException("Empty stack");
        return top.info;
    }

    public E pop() {

        if (isEmpty())
            throw new EmptyStackException("Empty stack");
        
        E savedInfo = top.info;

        Elem<E> oldTop = top;
        Elem<E> newTop = top.next;

        top = newTop;

        oldTop.info = null; // scrubbing the memory
        oldTop.next = null; // scrubbing the memory

        return savedInfo;
    }
}
