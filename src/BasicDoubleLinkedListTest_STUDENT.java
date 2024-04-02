import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * You must implement the following test case methods
 */
class BasicDoubleLinkedListTest_STUDENT {
	BasicDoubleLinkedList<String> link;
	public String s1= "Angela";
	public String s2= "Maggie";
	public String s3= "Steven";
	public String s4= "Thomas";
	public String s5= "Vicky";
	public ArrayList<String> list;
	StringComparator comparator;
	
	@BeforeEach
	void setUp() throws Exception {
		link = new BasicDoubleLinkedList<String>();
		link.addToEnd(s1);
		list = new ArrayList<String>();
		comparator = new StringComparator();
	}

	@AfterEach
	void tearDown() throws Exception {
		link = null;
		list = null;
		comparator = null;
	}

	@Test
	void testGetSize() {
		assertEquals(1,link.getSize());
	}

	@Test
	void testAddToEnd() {
		assertEquals(s1, link.getLast());
		link.addToEnd(s2);
		assertEquals(s2, link.getLast());
	}

	@Test
	void testAddToFront() {
		assertEquals(s1, link.getFirst());
		link.addToFront(s3);
		assertEquals(s3, link.getFirst());
		
	}

	@Test
	void testGetFirst() {
		assertEquals(s1, link.getFirst());
		link.addToFront(s4);
		assertEquals(s4, link.getFirst());
	}

	@Test
	void testGetLast() {
		assertEquals(s1, link.getLast());
		link.addToEnd(s5);
		assertEquals(s5, link.getLast());
	}

	@Test
	void testIterator() {
		link.addToFront(s2);
		link.addToEnd(s3);
		ListIterator<String> iterator = link.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(s2, iterator.next());
		assertEquals(s1, iterator.next());
		assertEquals(s3, iterator.next());
	}

	@Test
	void testRemove() {
		link.addToFront(s2);
		assertEquals(s2, link.getFirst());
		assertEquals(s1, link.getLast());
		link.remove(s1, comparator);
		assertEquals(s2, link.getFirst());
		assertEquals(1, link.getSize());
	}

	@Test
	void testRetrieveFirstElement() {
		assertEquals(s1, link.getFirst());
		link.addToFront(s2);
		assertEquals(s2, link.getFirst());
		assertEquals(s2, link.retrieveFirstElement());
		assertEquals(s1,link.getFirst());
	}

	@Test
	void testRetrieveLastElement() {
		assertEquals(s1, link.getLast());
		link.addToEnd(s2);
		assertEquals(s2, link.getLast());
		assertEquals(s2, link.retrieveLastElement());
		assertEquals(s1,link.getLast());
	}

	@Test
	void testToArrayList() {
		link.addToFront(s2);
		link.addToFront(s3);
		list = link.toArrayList();
		
		assertEquals(s3, list.get(0));
		assertEquals(s2, list.get(1));
		assertEquals(s1, list.get(2));
	}
	private class StringComparator implements Comparator<String> {
		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
	}

}
