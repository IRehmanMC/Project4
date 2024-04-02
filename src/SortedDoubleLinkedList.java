import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T>{
	private Comparator comp;
	
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		comp = compareableObject;
	}
	public SortedDoubleLinkedList<T> add(T data){
 		Link temp = new Link(data);
		Link on =firstLink;
		Link prev;
		if(sizeOfList == 0) {
			firstLink = temp;
			lastLink = temp;
			sizeOfList++;
			return this;
		}
		if(sizeOfList == 1) {
			if((comp.compare(data, on.data)) <= 0){
				super.addToFront(data);
				return this;
			}
			else {
				super.addToEnd(data);
				return this;
			}
		}
		else {
			while((comp.compare(on.data, data)) < 0) {
				prev = on;
				on = on.next;
				if(on == null) {
					on = temp;
					temp.previous = prev;
					prev.next = temp;
					lastLink = temp;
					sizeOfList++;
					return this;
				}
			}
			if(on == firstLink) {
				if((comp.compare(data, on.data)) < 0) {
					super.addToFront(data);
				}
			}
			else if(on == lastLink) {
				on.previous.next = temp;
				temp.next = on;
				temp.previous = on.previous;
				on.previous = temp;
				sizeOfList++;
			}
			else {
				on.previous.next = temp;
				temp.next = on;
				temp.previous = on.previous;
				on.previous = temp;
				sizeOfList++;
			}
		return this;
		}
	}
	public SortedDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	public SortedDoubleLinkedList<T> addToFront(T data){
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	public SortedDoubleLinkedList<T> remove(T targetData, Comparator<T>comparator){
		super.remove(targetData, comparator);
		return this;
	}
}