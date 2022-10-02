package doublylinkedlist;

import exceptions.EmptyListException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTestsIT {

    DoublyLinkedList<Integer> dll;

    @Before
    public void init() { // [8, 6, 3]
        dll = new DoublyLinkedList<>();
        dll.addFirst(3);
        dll.addFirst(6);
        dll.addFirst(8);
    }

    @After
    public void reset() {
        dll.clear();
    }

    @Test
    public void size_GetSizeOfTheList() {
        assertEquals(3, dll.getSize());
    }

    @Test
    public void getFirst_FirstItemOfTheList() throws EmptyListException {
        assertEquals(8, (int) dll.getFirst());
    }

    @Test
    public void getFirst_IfEmptyList_ThrowsException() {
        dll.clear();
        EmptyListException exception =
                assertThrows(EmptyListException.class, () -> dll.getFirst());
        assertTrue(exception.getMessage().contains("List is empty"));
    }

    @Test
    public void addFirst_AddItemToBeginningOfTheList() throws EmptyListException {
        dll.addFirst(17);
        assertEquals(17, (int) dll.getFirst());
    }

    @Test
    public void getLast_LastItemOfTheList() throws EmptyListException {
        assertEquals(3, (int) dll.getLast());
    }

    @Test
    public void getLast_IfEmptyList_ThrowsException() {
        dll.clear();
        EmptyListException exception =
                assertThrows(EmptyListException.class, () -> dll.getLast());
        assertEquals("List is empty", exception.getMessage());
    }

    @Test
    public void addLast_AddItemToEndOfTheList() throws EmptyListException {
        dll.addLast(25);
        assertEquals(25, (int) dll.getLast());
    }

    @Test
    public void get_GetItemWithValidIndex() {
        assertEquals(6, (int) dll.get(1));
    }

    @Test
    public void get_GetItemWithInvalidIndex_ThrowsException() {
        IndexOutOfBoundsException exception =
                assertThrows(IndexOutOfBoundsException.class, () -> dll.get(18));
        assertEquals("Invalid index", exception.getMessage());
    }

    @Test
    public void removeLast_RemoveLastItemFromTheList() throws EmptyListException {
        dll.removeLast();
        assertEquals(6, (int) dll.getLast());
    }

    @Test
    public void removeLast_RemoveLastItemFromTheList_ReturnRemovedItem() throws EmptyListException {
        int removedItem = dll.removeLast();
        assertEquals(3, removedItem);
    }

    @Test
    public void removeLast_RemoveLastItemFromEmptyList_ThrowsException() {
        dll.clear();
        EmptyListException exception =
                assertThrows(EmptyListException.class, () -> dll.removeLast());
        assertEquals("List is empty", exception.getMessage());
    }

    @Test
    public void removeFirst_RemoveFirstItemFromTheList() throws EmptyListException {
        dll.removeFirst();
        assertEquals(6, (int) dll.getFirst());
    }

    @Test
    public void removeFirst_RemoveFirstItemFromTheList_ReturnRemovedItem() throws EmptyListException {
        int removedItem = dll.removeFirst();
        assertEquals(8, removedItem);
    }

    @Test
    public void removeFirst_RemoveFirstItemFromEmptyList_ThrowsException() {
        dll.clear();
        EmptyListException exception =
                assertThrows(EmptyListException.class, () -> dll.removeFirst());
        assertEquals("List is empty", exception.getMessage());
    }
}
