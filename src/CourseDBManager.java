import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
	
public class CourseDBManager implements CourseDBManagerInterface{
	CourseDBStructure CDS = new CourseDBStructure(100);
	int credits;
	int CRN;
	String courses;
	String[] course;
	CourseDBElement CDE;
	
	public CourseDBManager() {
		int credits = 0;
		int CRN = 0;
		String courses = null;
		String[] course = null;
		CourseDBElement CDE = null;
	}
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement CDE = new CourseDBElement(id,crn,credits,roomNum,instructor);
		CDS.add(CDE);
	}
	public ArrayList<String> showAll(){
		return CDS.showAll();
	}
	public void readFile(File input) throws FileNotFoundException {
		Scanner in = new Scanner(input);
		
		while (in.hasNextLine()) {
			courses = in.nextLine();
			course = courses.split(" ",5);
			CRN = Integer.parseInt(course[1]);
			credits = Integer.parseInt(course[2]);
			CDE = new CourseDBElement(course[0], CRN, credits, course[3], course[4]);
			CDS.add(CDE);
		}
		in.close();
	}
	public CourseDBElement get(int crn) {
		try {
			return CDS.get(crn);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
