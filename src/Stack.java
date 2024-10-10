public class Stack<T> {
    private Node<T> head;

    void push(T data) {
        Node<T> newNode = new Node<>(data);

        newNode.next = this.head;

        this.head = newNode;
    }

    T pop() {
        if (isEmpty()) {
            return null;
        }

        Node<T> node = this.head;

        this.head = node.next;

        return node.data;
    }

    T peek() {
        if (isEmpty()) {
            return null;
        }

        return this.head.data;
    }

    boolean isEmpty() {
        return this.head == null;
    }

    int length() {
        int length = 0;

        Node<T> node = this.head;
        while (node != null) {
            length++;
            node = node.next;
        }

        return length;
    }

    boolean contains(StackSearchInterface<T> closure) {
        if (this.isEmpty()) {
            return false;
        }

        Node<T> node = this.head;
        while (node != null) {
            if (closure.search(node.data)) {
                return true;
            }
            node = node.next;
        }

        return false;
    }

    T fetch(StackSearchInterface<T> closure) {
        if (this.isEmpty()) {
            return null;
        }

        Node<T> node = this.head;
        while (node != null) {
            if (closure.search(node.data)) {
                return node.data;
            }
            node = node.next;
        }

        return null;
    }
}
