package medical.com.medicalApplication.model;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;



public class DoctorTest {

	private static Doctor doctor;
	
	@BeforeClass
public static void setUpBeforeClass() throws Exception {
		
		doctor = new Doctor("DoctorName", "ID");
	
	}
	
	
	@Test
	public final void testGetName() {
		assertTrue(doctor.getName().equals("DoctorName"));
		
	}

	@Test
	public final void testGetId() {
		
		assertTrue(doctor.getId().equals("ID"));
		
	}
	@Test
	public final void testSetName() {
		
		doctor.setName("DoctorName");
		
		assertTrue(doctor.getName().equals("DoctorName"));
		
	}

	@Test
	public final void testSetId() {
		
		doctor.setId("DOCID");
		
		assertTrue(doctor.getId().equals("DOCID"));
		
	}

	@Test
	public final void testToString() {
		assertTrue(doctor.toString().equals("Doctor Name: DoctorName ID: DOCID"));
	}
	

}
