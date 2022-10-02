package singlylinkedlist;

import exceptions.EmptyListException;

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

    public T getFirst() throws EmptyListException {
        try {
            return get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyListException("List is Empty");
        }
    }

    public void addLast(T item) {
        Node currentLast = getNode(size - 1);
        currentLast.next = new Node(item, null);
        size++;
    }

    public T getLast() throws EmptyListException {
        try {
            return get(size - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyListException("List is Empty");
        }
    }

    public T removeFirst() throws EmptyListException {
        if (size > 0) {
            T removedItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            size--;
            return removedItem;
        }
        throw new EmptyListException("List is Empty");
    }

    public T removeLast() throws EmptyListException {
        if (size > 0) {
            Node beforeLast = getNode(size - 2);
            T removedItem = beforeLast.next.item;
            beforeLast.next = null;
            size--;
            return removedItem;
        }
        throw new EmptyListException("List is Empty");
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

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.next = next;
            this.item = item;
        }
    }
}
