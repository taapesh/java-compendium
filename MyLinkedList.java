import java.util.HashMap;

public class MyLinkedList {
    private int size;
    public Node head;
    public Node tail;


    public MyLinkedList() {

    }

    public void append(Object data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void insert(Object data, int index) {
        if (index < 0 || index > size - 1) {
            return;
        }

        Node node = new Node(data);

        if (index == 0) {
            node.setNext(head);
            head = node;
            size++;

            if (size == 1) {
                tail = node;
            }
        } else {
            Node current = head;
            for(int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    public Object get(int index) {
        if (index < 0 || index > size - 1 || head == null) {
            return null;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public Object getLast() {
        return (tail != null) ? tail.getData() : null;
    }

    public Object getLastNode() {
        return tail;
    }

    public boolean remove(int index) {
        if (index < 0 || index > size - 1 || head == null) {
            return false;
        }

        if (index == 0) {
            Node next = head.getNext();
            if (next != null) {
                head = next;
            } else {
                head = null;
            }
            return true;
        } else {
            Node current = head;
            int currIdx = 0;

            while(currIdx < index - 1) {
                current = current.getNext();
                currIdx++;
            }

            if (currIdx == size - 2) {
                tail = current;
                current.setNext(null);
            } else {
                current.setNext(current.getNext().getNext());
            }
            size--;
            return true;
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            sb.append("[");
            sb.append(current.getData().toString());
            sb.append("]");
            current = current.getNext();
        }
        return sb.toString();
    }

    public void createLoop() {
        tail.setNext(head);
    }

    class Node {
        Node next;
        Object data;

        public Node(Object o) {
            next = null;
            data = o;
        }

        public Node(Object d, Node n) {
            next = n;
            data = d;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object d) {
            data = d;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }
    }
}

