import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test template provided to students
 * Students must implement the methods
 * 
 * @author Farnaz Eivazi
 * @version 1/31/2024
 *
 */
class CourseDBManagerTest_STUDENT {
	private CourseDBManager courseMan = new CourseDBManager();
	@BeforeEach
	void setUp() throws Exception {
		 courseMan = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		 courseMan = null;
	}

	@Test
	void testAdd() {
		try {
			courseMan.add("CMSC204", 12345, 4, "HS102", "Ilyas Rehman");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	void testShowAll() {
		courseMan.add("CMSC123", 12345, 1, "HS123", "Ilyas Rehman");
		courseMan.add("MATH123", 54321, 3, "HS321", "Ilyas Rehman");
		courseMan.add("SOCY123", 15432, 3, "HS312", "Ilyas Rehman");
		courseMan.add("ENGL123", 45321, 4, "HS231", "Ilyas Rehman");
		ArrayList<String> list = courseMan.showAll();
		
		assertEquals(list.get(0), "\nCourse:SOCY123 CRN:15432 Credits:3 Instructor:Ilyas Rehman Room:HS312");
		assertEquals(list.get(1), "\nCourse:MATH123 CRN:54321 Credits:3 Instructor:Ilyas Rehman Room:HS321");
  		assertEquals(list.get(2), "\nCourse:CMSC123 CRN:12345 Credits:1 Instructor:Ilyas Rehman Room:HS123");
		assertEquals(list.get(3), "\nCourse:ENGL123 CRN:45321 Credits:4 Instructor:Ilyas Rehman Room:HS231");
	}

	@Test
	void testReadFile() {
		try {
			File inputFile = new File("Test.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("MATH123 54321 5 UB321 Ilyas Rehman");
			inFile.print("ENGL123 12345 4 UB123 Ilyas Rehman");
			inFile.close();
			courseMan.readFile(inputFile);
			
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}

	@Test
	void testGet() {
		CourseDBElement test1 = new CourseDBElement("CHEM123", 12345, 1, "HS123", "Ilyas Rehman");
		CourseDBElement test2 = new CourseDBElement("PHYS123", 54321, 2, "HS321", "Ilyas Rehman");
		courseMan.add("CHEM123", 12345, 1, "HS123", "Ilyas Rehman");
		courseMan.add("PHYS123", 54321, 2, "HS321", "Ilyas Rehman");
		assertEquals(0, courseMan.get(12345).compareTo(test1));
		assertEquals(0, courseMan.get(54321).compareTo(test2));
	}

}
