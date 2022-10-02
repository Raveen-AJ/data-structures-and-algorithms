package singlylinkedlist;

import exceptions.EmptyListException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTestsIT {

    private SinglyLinkedList<Integer> sll;

    @Before
    public void init() {
        sll = new SinglyLinkedList<>(); // [1, 2, 3]
        sll.addFirst(3);
        sll.addFirst(2);
        sll.addFirst(1);
    }

    @After
    public void reset() {
        sll.clear();
    }

    @Test
    public void size_SizeOfList() {
        assertEquals(3, sll.getSize());
    }

    @Test
    public void get_ItemAtInvalidIndex_ThrowsException() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> sll.get(100));
        assertTrue(exception.getMessage().contains("Invalid index"));
    }

    @Test
    public void get_ItemAtValidIndex() {
        assertEquals(2, (int) sll.get(1));
    }

    @Test
    public void getFirst_FirstItemFromEmptyList_ThrowsException() {
        sll.clear();
        EmptyListException exception =
                assertThrows(EmptyListException.class, () -> sll.getFirst());
        assertTrue(exception.getMessage().contains("List is Empty"));
    }

    @Test
    public void getFirst_FirstItemOfTheList() throws EmptyListException {
        assertEquals((int) sll.getFirst(), 1);
    }

    @Test
    public void getLast_LastItemFromEmptyList_ThrowsException() {
        sll.clear();
        EmptyListException exception =
                assertThrows(EmptyListException.class, () -> sll.getLast());
        assertTrue(exception.getMessage().contains("List is Empty"));
    }

    @Test
    public void getLast_LastItemOfTheList() throws EmptyListException {
        assertEquals((int) sll.getLast(), 3);
    }

    @Test
    public void addFirst_AddItemToBeginningOfTheList() throws EmptyListException{
        sll.addFirst(10);
        assertEquals((int) sll.getFirst(), 10);
    }

    @Test
    public void addLast_AddItemToEndOfTheList() throws EmptyListException{
        sll.addLast(20);
        assertEquals((int) sll.getLast(), 20);
    }

    @Test
    public void removeFirst_RemoveFirstItemOfTheList_ReturnsRemovedItem() throws Exception {
        int removedItem = sll.removeFirst();
        assertEquals(1, removedItem);
    }

    @Test
    public void removeFirst_RemoveFirstItemOfTheList_NewFirstItemIsSecondItemsOfPreviousList() throws Exception {
        sll.removeFirst();
        assertEquals(2, (int) sll.getFirst());
    }

    @Test
    public void removeLast_RemoveLastItemOfTheList_ReturnsRemovedItem() throws Exception {
        int removedItem = sll.removeLast();
        assertEquals(3, removedItem);
    }

    @Test
    public void removeLast_RemoveLastItemOfTheList_NewLastItemIsSecondToLastOfPreviousList() throws Exception {
        sll.removeLast();
        assertEquals(2, (int) sll.getLast());
    }
}
