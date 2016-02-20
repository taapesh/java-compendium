import java.util.EmptyStackException;

public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private int size = 0;
    private QueueNode<T> top;
    private QueueNode<T> tail;

    public void enqueue(T item) {
        QueueNode<T> node = new QueueNode<T>(item);

        if (top == null) {
            top = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T dequeue() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;

        if (top == null) {
            tail = null;
        }

        size--;
        return item;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public int size() {
        return size;
    }
}
