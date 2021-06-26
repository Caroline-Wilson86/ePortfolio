package medical.com.medicalApplication.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class AllergeyTest {
	
	private static Allergey allergey;

	@BeforeClass
	public static void BeforeClass() {
		
		allergey = new Allergey("AllergeyName");
	}
	
	@Test
	public final void testSetName() {
		assertTrue(allergey.getName().equals("AllergeyName"));
	}
	
	@Test
	public final void testToString() {
		assertTrue(allergey.toString().equals("Allergey AllergeyName"));
	}
	
	@Test
	public final void testGetName() {
		assertTrue(allergey.getName().equals("AllergeyName"));
		
	}


}
