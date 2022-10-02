package doublylinkedlist;

import exceptions.EmptyListException;

public class DoublyLinkedList<T> {
    Node sentinel;
    private int size;

    public DoublyLinkedList() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node temp = sentinel.next;
        sentinel.next = new Node(item, sentinel.next, sentinel);
        temp.prev = sentinel.next;
        size++;
    }

    public T getFirst() throws EmptyListException {
        Node item =  sentinel.next;
        if (item == sentinel) {
            throw new EmptyListException("List is empty");
        }
        return item.item;
    }

    public void addLast(T item) {
        Node temp = sentinel.prev;
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        temp.next = sentinel.prev;
        size++;
    }

    public T getLast() throws EmptyListException {
        Node item =  sentinel.prev;
        if (item == sentinel) {
            throw new EmptyListException("List is empty");
        }
        return item.item;
    }

    public T removeLast() throws EmptyListException {
        Node lastNode = sentinel.prev;
        if (lastNode == sentinel) {
            throw new EmptyListException("List is empty");
        }
        lastNode.prev.next = sentinel;
        sentinel.prev = lastNode.prev;
        return lastNode.item;
    }

    public T removeFirst() throws EmptyListException {
        Node firstNode = sentinel.next;
        if (firstNode == sentinel) {
            throw new EmptyListException("List is empty");
        }
        firstNode.next.prev = sentinel;
        sentinel.next = firstNode.next;
        return firstNode.item;
    }

    public int getSize() {
        return size;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        Node node = getNodeAt(index);
        if (node == null) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return node.item;
    }

    private Node getNodeAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return sentinel.next;
        }
        if (index == size - 1) {
            return sentinel.prev;
        }

        Node p = sentinel.next.next;
        int i = 1;
        while (p != null) {
            if (i == index) {
                break;
            }
            p = p.next;
            i++;
        }

        return p;
    }

    public void clear() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    private class Node {
        T item;
        Node next;
        Node prev;

        public Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
