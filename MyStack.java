import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private int size = 0;
    private StackNode<T> top;

    public void push(T item) {
        StackNode<T> node = new StackNode<T>(item);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
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
