package medical.com.medicalApplication.services;

import static org.junit.Assert.*;


//import java utilities needed for lists CEW
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

//import junit utilities for testing. CEW
import org.junit.BeforeClass;
import org.junit.Test;

//import models and services CEW
import medical.com.medicalApplication.model.*;
import medical.com.medicalApplication.services.*;

public class MedicalRescordServiceTest {
 //initialize variables CEW
	private static MedicalRecord medicalRecord;
	private static Patient patient;
	private static List<MedicalRecord> recordList;
	private static List<Patient> patientList;
	
	//setup before class to ensure correct pointers CEW
	@BeforeClass
	public static void setUpMedAppTest() throws Exception {
		patientList = new ArrayList<Patient>();
		//typo in Service Name CEW
		patientList = MedicalRescordService.getReference().getAllPatients();
		recordList = new ArrayList<MedicalRecord>();
		patient = new Patient("PatientName", "PatientID");
				
	}

	@Test
	public void testAddPatient() {
		assertTrue(MedicalRescordService.getReference().addPatient("Patient1", "ID1"));
		assertTrue(MedicalRescordService.getReference().addPatient("Patient2", "ID2"));
		assertTrue(MedicalRescordService.getReference().addPatient("Patient3", "ID3"));
		
	}
	
	@Test
	public void testGetMedicalRecord() {
		MedicalRescordService.getReference().getMedicalRecord("ID1");
		MedicalRescordService.getReference().getMedicalRecord("ID2");
		MedicalRescordService.getReference().getMedicalRecord("ID3");
		
	}
	
	@Test
	public void testGetPatient() {
		MedicalRescordService.getReference().getPatient("ID1");
		MedicalRescordService.getReference().getPatient("ID2");
		MedicalRescordService.getReference().getPatient("ID3");
	}
	
	@Test
	public void testGetAllPatients() {
		assertTrue(MedicalRescordService.getReference().getAllPatients().equals(patientList));
	}
	
	@Test
	public void testGetPatientsWithAllergies() {
		assertTrue(MedicalRescordService.getReference().getPatientsWithAllergies("Latex").equals(patientList));
	}
}
