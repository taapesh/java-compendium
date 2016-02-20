public class MyLinkedList<T> {
    private int size;
    public Node<T> head;
    public Node<T> tail;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T data) {
            this.data = data;
        }
    }

    public void append(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insert(T data, int index) {
        if (index < 0 || index > size - 1) {
            return;
        }

        Node<T> node = new Node<>(data);

        if (index == 0) {
            node.next = head;
            head = node;
            size++;

            if (size == 1) {
                tail = node;
            }
        } else {
            Node<T> current = head;
            for(int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            size++;
        }
    }

    public T get(int index) {
        if (index < 0 || index > size - 1 || head == null) {
            return null;
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public T getLast() {
        return (tail != null) ? tail.data : null;
    }

    public Node getLastNode() {
        return tail;
    }

    public boolean remove(int index) {
        if (index < 0 || index > size - 1 || head == null) {
            return false;
        }

        Node<T> current = head;
        int currIdx = 0;

        while (currIdx < index - 1) {
            current = current.next;
            currIdx++;
        }

        if (currIdx == size - 2) {
            // Set new tail
            tail = current;
        }

        current.next = current.next.next;
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            sb.append("[");
            sb.append(current.data.toString());
            sb.append("]");
            current = current.next;
        }
        return sb.toString();
    }

    public void createLoop() {
        tail.next = head;
    }
}