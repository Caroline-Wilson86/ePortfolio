package medical.com.medicalApplication.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TreatmentTest {
	
	private static Treatment treatment;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	treatment = new Treatment("TreatDate", "Diagnose", "Description");
	
	}
	

	@Test
	public final void testGetTreatmentDate() {
		assertTrue(treatment.getTreatmentDate().equals("TreatDate"));
		
	}
	
	@Test
	public final void testSetTreatDate() {
		
		treatment.setTreatmentDate("TreatDate");
		
		assertTrue(treatment.getTreatmentDate().equals("TreatDate"));
		
	}
	
	@Test
	public final void testDiagnose() {
		assertTrue(treatment.getDiagnose().equals("Diagnose"));
		
	}
	
	@Test
	public final void testSetDiagnose() {
		
		treatment.setDiagnose("Diagnose");
		
		assertTrue(treatment.getDiagnose().equals("Diagnose"));
		
	}
	
	@Test
	public final void testGetDescription() {
		assertTrue(treatment.getDescription().equals("Description"));
		
	}
	
	@Test
	public final void testSetDescription() {
		
		treatment.setDescription("Description");
		
		assertTrue(treatment.getDescription().equals("Description"));
		
	}
}
