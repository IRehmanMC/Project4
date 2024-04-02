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
class CourseDBStructureTest_STUDENT {
	private CourseDBElement courseEle1 = new CourseDBElement("CMSC123", 12345, 1, "HS123", "Ilyas Rehman");
	private CourseDBElement courseEle2 = new CourseDBElement("MATH123", 54321, 3, "HS321", "Ilyas Rehman");
	private CourseDBElement courseEle3 = new CourseDBElement("SOCY123", 15432, 3, "HS312", "Ilyas Rehman");
	CourseDBStructure struct, test;
	
	
	@BeforeEach
	void setUp() throws Exception {
		struct = new CourseDBStructure(100);
		test = new CourseDBStructure("Testing", 100);
	}

	@AfterEach
	void tearDown() throws Exception {
		struct = null;
		test = null;
	}

	@Test
	void testCourseDBStructureStringInt() {
	      CourseDBStructure test = new CourseDBStructure("name", 500);
	        assertEquals(500, test.getTableSize());
	}

	@Test
	void testCourseDBStructureInt() {
        CourseDBStructure test = new CourseDBStructure(500);
        assertEquals(347, test.getTableSize());
	}

	@Test
	void testAdd() {
		try {
			struct.add(courseEle1);
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}	}

	@Test
	void testShowAll() {
		struct.add(courseEle1);
		struct.add(courseEle2);
		struct.add(courseEle3);
		ArrayList<String> list = struct.showAll();
		
		assertEquals(list.get(0), "\nCourse:SOCY123 CRN:15432 Credits:3 Instructor:Ilyas Rehman Room:HS312");
		assertEquals(list.get(1), "\nCourse:MATH123 CRN:54321 Credits:3 Instructor:Ilyas Rehman Room:HS321");
  		assertEquals(list.get(2), "\nCourse:CMSC123 CRN:12345 Credits:1 Instructor:Ilyas Rehman Room:HS123");
	}

	@Test
	void testGet() {
			CourseDBElement test = new CourseDBElement("CMSC123", 12345 , 2,"HS450","Ilyas Rehman"); 
			struct.add(test);
			try {
				struct.get(12345);
				assertEquals(test,struct.get(12345));
			}
			catch(IOException e) {
				fail("Should not have thrown an exception");
			}
	}

	@Test
	void testGetTableSize() {
		assertEquals(67, struct.getTableSize());
		assertEquals(100, test.getTableSize());	
	}

	@Test
	void testGet4KPrime() {
        CourseDBStructure test = new CourseDBStructure(1);
        assertEquals(2, test.getTableSize());
        CourseDBStructure test2 = new CourseDBStructure(200);
        assertEquals(139, test2.getTableSize());
        CourseDBStructure test3 = new CourseDBStructure(400);
        assertEquals(271, test3.getTableSize());
	}

}
