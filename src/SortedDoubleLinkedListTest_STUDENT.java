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
class SortedDoubleLinkedListTest_STUDENT {
	SortedDoubleLinkedList<String> link;
	public String s1= "Angela";
	public String s2= "Maggie";
	public String s3= "Steven";
	public String s4= "Thomas";
	public String s5= "Vicky";
	public ArrayList<String> list;
	StringComparator comparator;
	
	@BeforeEach
	void setUp() throws Exception {
		comparator = new StringComparator();
		link = new SortedDoubleLinkedList<String>(comparator);
		list = new ArrayList<String>();
	}

	@AfterEach
	void tearDown() throws Exception {
		comparator = null;
		link = null;
		list = null;
	}

	@Test
	void testIterator() {
		link.add(s1);
		link.add(s2);
		link.add(s3);
		link.add(s4);
		ListIterator<String> iterator = link.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(s1, iterator.next());
		assertEquals(s2, iterator.next());
		assertEquals(s3, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	void testRemove() {
		link.add(s1);
		link.add(s2);
		assertEquals(s1, link.getFirst());
		assertEquals(s2, link.getLast());
		link.remove(s2, comparator);
		assertEquals(s1, link.getFirst());
	}

	@Test
	void testAdd() {
		link.add(s1);
		link.add(s2);
		link.add(s3);
		assertEquals(s1, link.getFirst());
		assertEquals(s3, link.getLast());
		link.add(s4);
		link.add(s5);
		assertEquals(s5, link.getLast());
		assertEquals(s5, link.retrieveLastElement());
	}
	private class StringComparator implements Comparator<String> {
		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
	}

}
