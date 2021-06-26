package medical.com.medicalApplication.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PatientTest {
	
	private static Patient patient;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	patient = new Patient("PatientName", "PatientId");
	
	}

	@Test
	public final void testGetName() {
		assertTrue(patient.getName().equals("PatientName"));
		
	}

	@Test
	public final void testGetId() {
		
		assertTrue(patient.getId().equals("PatientId"));
		
	}
	@Test
	public final void testSetName() {
		
		patient.setName("PatientName");
		
		assertTrue(patient.getName().equals("PatientName"));
		
	}

	@Test
	public final void testSetId() {
		
		patient.setId("PatientId");
		
		assertTrue(patient.getId().equals("PatientId"));
		
	}

	@Test
	public final void testToString() {
		assertTrue(patient.toString().equals("Patient Name: PatientName ID: PatientId"));
	}
	
	

}
