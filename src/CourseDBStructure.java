import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {
	ArrayList<LinkedList<CourseDBElement>> hashTable;
	
	public CourseDBStructure(String numElements, int size) {
		hashTable = new ArrayList<LinkedList<CourseDBElement>>();
		for (int i = 0; i < size; i++)
		{
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}
	public CourseDBStructure(int num) {
		hashTable = new ArrayList<LinkedList<CourseDBElement>>();
		double loadFacNum = num / 1.5;
		int size = get4KPrime((int) loadFacNum);
		for (int i = 0; i < size; i++)
		{
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}
	public void add(CourseDBElement element) {
		LinkedList<CourseDBElement> bucket;
		
		for (int i = 0; i < getTableSize(); i++)
		{
			bucket = hashTable.get(i);
			for (int j = 0; j < bucket.size(); j++)
			{
				if (element.getCRN() == bucket.get(j).getCRN())
				{
					bucket.set(j, element);
					return;
				}
			}
		}
		int index = element.hashCode() % hashTable.size();
		hashTable.get(index).add(element);
	}
	public ArrayList<String> showAll() {
		ArrayList<String> returner = new ArrayList<String>();
		LinkedList<CourseDBElement> bucket;
		CourseDBElement iter;
		
		for (int i = 0; i < hashTable.size(); i++)
		{
			bucket = hashTable.get(i);
			for (int j = 0; j < bucket.size(); j++)
			{
				iter = bucket.get(j);
				if (iter != null)
				{
					returner.add("\nCourse:" + iter.getID() + " CRN:" + iter.getCRN() + " Credits:" + iter.getCredits() + " Instructor:" + iter.getInstructor() + " Room:" + iter.getRoomNum());
				}
			}
		}
		return returner;
	}
	public CourseDBElement get(int crn) throws IOException {
		LinkedList<CourseDBElement> bucket;
		for (int i = 0; i < getTableSize(); i++)
		{
			bucket = hashTable.get(i);
			for (int j = 0; j < bucket.size(); j++)
			{
				if (bucket.get(j).getCRN() == crn) {
					return bucket.get(j);
				}
			}
		}
		throw new IOException();
	}
	public int getTableSize() {
		return hashTable.size();
	}
	public static int get4KPrime(int num) {
		boolean prime = false;
		while (!prime) {
            num++;
            if (num <= 1) {
                continue;
            }
            if (num <= 3) {
            	prime = true;
                break;
            }
            if (num % 2 == 0 || num % 3 == 0) {
                continue;
            }
            
            boolean isPrime = true;
            for (int i = 5; i * i <= num; i += 6) {
                if (num % i == 0 || num % (i + 2) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
            	if (num % 4 == 3) {
                    isPrime = true;
                    return num;
                }
            }
        }
        return num;
	}	
}
	

