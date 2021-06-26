package medical.com.medicalApplication.model;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import medical.com.medicalApplication.model.*;
import medical.com.medicalApplication.services.*;

public class PatientHistoryTest {
		//Create public class, make room for arrays and each list from main CEW
		
		private PatientHistory history;
		private Treatment treatment;
		private Medication medication;
		private Allergey allergey;
		private List treatmentList = new ArrayList();
		private List medicationList = new ArrayList();
		private List allergeyList = new ArrayList();
		private List patientList = new ArrayList();
		
		@BeforeClass
		public void setUpBeforeClass() throws Exception {
			
			this.medication = new Medication("Aspirin", "01/01/2020", "07/01/2020", "1");
			this.allergey = new Allergey("Latex");
			this.treatment = new Treatment("01/01/2020", "Chest Pain", "Hypertension");
		//fix! getReference undefined!  CEW	
			//fix implemented. defined in main patient history CEW
			
			PatientHistory.getReference().addMedication(medication);
			PatientHistory.getReference().addAllergy(allergey);
			PatientHistory.getReference().addTreatment(treatment);
			
			this.treatmentList = PatientHistory.getReference().getAllTreatments();
			this.medicationList = PatientHistory.getReference().getAllMedications();
			this.allergeyList = PatientHistory.getReference().getAlergies();
			
		}
		
		//ensure items are added to patient list as required CEW
		@Test
		public void testAddTreatment() {
		    assertTrue(PatientHistory.getReference().getAllTreatments().equals(treatmentList));
		}
		
		@Test
		public void testAddMedication() {
		    assertTrue(PatientHistory.getReference().getAllMedications().equals(treatmentList));
		}
		
		@Test
		public void testAddAllergey() {
		    assertTrue(PatientHistory.getReference().getAlergies().equals(treatmentList));
		}
		
	}

