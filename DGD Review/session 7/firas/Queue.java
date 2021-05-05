public interface Queue<E> {

    boolean isEmpty();
    E peek();
    E dequeue();
    void enqueue(E e);
}
