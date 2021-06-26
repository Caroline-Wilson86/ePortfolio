package medical.com.medicalApplication.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class MedicationTest {
	
	private static Medication medication;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	medication = new Medication("MedName", "StartDate", "EndDate", "Dose");
	
	}
	
	@Test
	public final void testGetName() {
		assertTrue(medication.getName().equals("MedName"));
		
	}
	
	@Test
	public final void testGetStartDate() {
		assertTrue(medication.getStartDate().equals("StartDate"));
		
	}
	
	@Test
	public final void testEndDate() {
		assertTrue(medication.getEndDate().equals("EndDate"));
		
	}
	
	@Test
	public final void testGetDose() {
		assertTrue(medication.getDose().equals("Dose"));
		
	}
	
	@Test
	public final void testSetName() {
		
		medication.setName("MedName");
		
		assertTrue(medication.getName().equals("MedName"));
		
	}
	
	@Test
	public final void testSetStartDate() {
		
		medication.setStartDate("StartDate");
		
		assertTrue(medication.getStartDate().equals("StartDate"));
		
	}
	@Test
	public final void testSetEndDate() {
		
		medication.setEndDate("EndDate");
		
		assertTrue(medication.getEndDate().equals("EndDate"));
		
	}
	
	@Test
	public final void testSetDose() {
		
		medication.setDose("Dose");
		
		assertTrue(medication.getDose().equals("Dose"));
		
	}
	
	@Test
	public final void testToString() {
		assertTrue(medication.toString().equals("Medication: MedName Start Date: StartDate End Date: EndDate Dose: Dose"));
	}
	
	
	

}
