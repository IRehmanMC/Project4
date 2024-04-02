import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> {
	protected Link firstLink;
	protected Link lastLink;
	protected int sizeOfList = 0;
	
	public BasicDoubleLinkedList() {
		firstLink = null;
		lastLink = null;
		
	}
	public int getSize() {
		return sizeOfList;
	}
	public boolean isEmpty() {
		if(sizeOfList == 0) {
			return true;
		}
		return false;
	}
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Link temp = new Link(data);
		
		if(isEmpty()) {
			firstLink = temp;	
		}
		else {
			lastLink.next = temp;
			temp.previous = lastLink;	
		}
		lastLink = temp;
		sizeOfList++;
		return this;
	}
	public BasicDoubleLinkedList<T> addToFront(T data){
		Link temp = new Link(data);
		
		if(isEmpty()) {
			lastLink = temp;
		}
		else {
			temp.next = firstLink;
			firstLink.previous = temp;	
		}
		firstLink = temp;
		sizeOfList++;
		return this;
	}
	public T getFirst() {
		if(isEmpty()) {
			return null;
		}
		return firstLink.data;
	}
	public T getLast() {
		if(isEmpty()) {
			return null;
		}
		return lastLink.data;
	}
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		Link on = firstLink;
		Link prev = null;
		Link found = null;
		
		while(!isEmpty()) {
			if((comparator.compare(targetData, on.data)) == 0) {
				if(sizeOfList == 1) {
					found = firstLink;
					firstLink = null;
					lastLink = null;
					sizeOfList--;
					break;
				}
				else if(on == firstLink) {
					found = on;
					firstLink.next.previous = null;
					firstLink = firstLink.next;
					sizeOfList--;
					break;
				}
				else if(on == lastLink){
					found = on;
					lastLink.previous.next = null;
					lastLink = lastLink.previous;
					sizeOfList--;
					break;
				}
				else {
					found = on;
					on.previous.next = on.next;
					on.next.previous = on.previous;
					sizeOfList--;
					break;
				}
			}
			prev = on;
			on = on.next;
		}
		return this;
	}
	public T retrieveFirstElement() {
		if(isEmpty()) {
			return null;
		}
		else if(sizeOfList == 1) {
			T first = getFirst();
			firstLink = null;
			lastLink = null;
			sizeOfList--;
			return first;
		}
		else {
			T first = getFirst();
			firstLink.next.previous = null;
			firstLink = firstLink.next;
			sizeOfList--;
			return first;
		}	
	}
	public T retrieveLastElement() {
		if(isEmpty()) {
			return null;
		}
		else if(sizeOfList == 1) {
			T last = getLast();
			firstLink = null;
			lastLink = null;
			sizeOfList--;
			return last;
		}
		else {
			T last = getLast();
			lastLink.previous.next = null;
			lastLink = lastLink.previous;
			sizeOfList--;
			return last;
		}
	}
	public ArrayList<T> toArrayList(){
		ArrayList<T> list = new ArrayList<T>();
		ListIterator<T> iterator = iterator();
		
		while(iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
		return new DoubleLinkedListIterator();
	}
	protected class Link{
		public Link previous;
		public Link next;
		public T data;
		
		Link(){
			previous = null;
			next = null;
			data = null;
		}
		Link(T data){
			this.data = data;
		}
	}
	protected class DoubleLinkedListIterator implements ListIterator<T> {
		private Link previousL;
		private Link currentL;
		
		DoubleLinkedListIterator(){
			previousL = null;
			currentL = firstLink;
		}
		public void add(T arg0) {
			throw new UnsupportedOperationException();
		}
		public boolean hasNext() {
			return currentL != null;
		}
		public boolean hasPrevious() {
			return previousL != null;
		}
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
				previousL = currentL;
				currentL = currentL.next;
				return previousL.data;
			}
		}
		public T previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			else {
				currentL = previousL;
				previousL = previousL.previous;
				return currentL.data;
			}
		}
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
		public void set(T e) {
			throw new UnsupportedOperationException();
		}
	}
}