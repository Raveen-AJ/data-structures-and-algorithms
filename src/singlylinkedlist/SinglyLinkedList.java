package singlylinkedlist;

public class SinglyLinkedList<T> {

    private final Node sentinel;
    private int size;

    public SinglyLinkedList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel.next);
        size++;
    }

    public T getFirst() throws IndexOutOfBoundsException {
        try {
            return get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("There are no items in the list");
        }
    }

    public void addLast(T item) {
        Node currentLast = getNode(size - 1);
        currentLast.next = new Node(item, null);
        size++;
    }

    public T getLast() throws IndexOutOfBoundsException {
        try {
            return get(size - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("There are no items in the list");
        }
    }

    public T removeFirst() throws Exception {
        if (size > 0) {
            T removedItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            size--;
            return removedItem;
        }
        throw new Exception("There are no items to remove");
    }

    public T removeLast() throws Exception {
        if (size > 0) {
            Node beforeLast = getNode(size - 2);
            T removedItem = beforeLast.next.item;
            beforeLast.next = null;
            size--;
            return removedItem;
        }
        throw new Exception("There are no items to remove");
    }

    public T get(int index) {
        Node item = getNode(index);
        if (item == sentinel) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return item.item;
    }

    private Node getNode(int index) {
        Node currentNode = sentinel.next;
        int i = 0;
        while (currentNode != null) {
            if (i == index) {
                return currentNode;
            }
            currentNode = currentNode.next;
            i++;
        }
        return sentinel;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        sentinel.next = null;
        size = 0;
    }

    public class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.next = next;
            this.item = item;
        }
    }
}
