package medical.com.medicalApplication.model;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;

import medical.com.medicalApplication.model.MedicalRecord;

import medical.com.medicalApplication.model.Patient;
import medical.com.medicalApplication.model.PatientHistory;

public class MedicalRecordTest {
	
	private static Patient patient = new Patient("PatientName", "PatientHistory");
	private static PatientHistory history = new PatientHistory();
	private static MedicalRecord medicalRecord;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		medicalRecord = new MedicalRecord(patient);
		history = new PatientHistory(); 
	}


	@Test
	public final void testGetPatient() {
		assertTrue(medicalRecord.getPatient().equals(patient));
		
	}

	@Test
	public final void testGetHistory() {
		
		medicalRecord.getHistory().equals(history);
		
	}
}
