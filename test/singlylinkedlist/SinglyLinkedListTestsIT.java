package singlylinkedlist;

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
    public void size_sizeOfList() {
        assertEquals(3, sll.getSize());
    }

    @Test
    public void get_itemAtInvalidIndex_ThrowsException() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> sll.get(100));
        assertTrue(exception.getMessage().contains("Invalid index"));
    }

    @Test
    public void get_itemAtValidIndex() {
        assertEquals(2, (int) sll.get(1));
    }

    @Test
    public void getFirst_firstItemFromEmptyList_ThrowsException() {
        sll.clear();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> sll.getFirst());
        assertTrue(exception.getMessage().contains("There are no items in the list"));
    }

    @Test
    public void getFirst_firstItemOfTheList() {
        assertEquals((int) sll.getFirst(), 1);
    }

    @Test
    public void getLast_lastItemFromEmptyList_ThrowsException() {
        sll.clear();
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> sll.getLast());
        assertTrue(exception.getMessage().contains("There are no items in the list"));
    }

    @Test
    public void getLast_lastItemOfTheList() {
        assertEquals((int) sll.getLast(), 3);
    }

    @Test
    public void addFirst_addItemToBeginningOfTheList() {
        sll.addFirst(10);
        assertEquals((int) sll.getFirst(), 10);
    }

    @Test
    public void addLast_addItemToEndOfTheList() {
        sll.addLast(20);
        assertEquals((int) sll.getLast(), 20);
    }

    @Test
    public void removeFirst_removeFirstItemOfTheList_returnsRemovedItem() throws Exception {
        int removedItem = sll.removeFirst();
        assertEquals(1, removedItem);
    }

    @Test
    public void removeFirst_removeFirstItemOfTheList_newFirstItemIsSecondItemsOfPreviousList() throws Exception {
        sll.removeFirst();
        assertEquals(2, (int) sll.getFirst());
    }

    @Test
    public void removeLast_removeLastItemOfTheList_returnsRemovedItem() throws Exception {
        int removedItem = sll.removeLast();
        assertEquals(3, removedItem);
    }

    @Test
    public void removeLast_removeLastItemOfTheList_newLastItemIsSecondToLastOfPreviousList() throws Exception {
        sll.removeLast();
        assertEquals(2, (int) sll.getLast());
    }
}
