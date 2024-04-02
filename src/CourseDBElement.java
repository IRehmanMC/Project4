
public class CourseDBElement implements Comparable<CourseDBElement> {
	private String ID;
	private  int CRN;
	private  int credits;
	private  String roomNum;
	private String instructor;
	
	public int compareTo(CourseDBElement element) {
		if(element.CRN == CRN) {
			return 0;
		}
		else if(element.CRN > CRN) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public CourseDBElement() {
		super();
		ID = null;
		CRN = 0;
		this.credits = 0;
		this.roomNum = null;
		this.instructor = null;
	}
	public CourseDBElement(CourseDBElement element) {
		super();
		ID = element.ID;
		CRN = element.CRN;
		this.credits = element.credits;
		this.roomNum = element.roomNum;
		this.instructor = element.instructor;
	}
		
	public CourseDBElement(String iD, int cRN, int credits, String roomNum, String instructor) {
		super();
		ID = iD;
		CRN = cRN;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getCRN() {
		return CRN;
	}
	public void setCRN(int cRN) {
		CRN = cRN;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	public int hashCode() {
		String returner = Integer.toString(CRN);
		return returner.hashCode();
	}
	public boolean equals(CourseDBElement element) {
		if(CRN == element.CRN) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		return "Course:" + ID + " CRN:" + CRN + " Credits:" + credits + " Instructor:" + roomNum + " Room:" + instructor;
	}
	
}
