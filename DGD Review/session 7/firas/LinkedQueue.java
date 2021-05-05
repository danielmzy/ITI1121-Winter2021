public class LinkedQueue<E> implements Queue<E> {

    private static class Elem<T> {
        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next){
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> front;
    private Elem<E> rear;

    public boolean isEmpty(){
        return front == null;
    }

    public E peek(){
        if(front == null){
            return null;
        }
        return front.value;
    }

    public E dequeue(){
        if(front == null){
            return null;
        }
        E value = front.value;

        if(front.next == null){
            front = rear = null;
        } else {
            front = front.next;
        }

        return value;
    }

    public void enqueue(E e){

        if(e == null){
            throw new NullPointerException();
        }

        Elem<E> newElem = new Elem<>(e, null);

        if(rear == null){
            rear = front = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }
    }

    public String toString(){
        String str = "[";
        Elem<E> p = front;

        while (p != null) {
            if (p != front) {
                str += ", ";
            }
            str += p.value;
            p = p.next;
        }
        str += "]";
        return str;
    }
}
