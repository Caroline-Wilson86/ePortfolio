package medical.com.medicalApplication.services;

import static org.junit.Assert.*;


//import java utilities needed for lists CEW
import java.util.List;
import java.util.ArrayList;

//import junit utilities for testing. CEW
import org.junit.BeforeClass;
import org.junit.Test;

//import models and services CEW
import medical.com.medicalApplication.model.Doctor;
import medical.com.medicalApplication.services.DoctorService;

public class DoctorServiceTest {

	private static Doctor doctor;
	private static List doctorList = new ArrayList();
	
	@BeforeClass
	public static void setUpDoctorList() throws Exception {
		DoctorService.getReference().addDoctor("DoctorName", "DOCID");
		doctorList = DoctorService.getReference().getAllDoctors();
		
		
	}
	
	@Test
	public final void testAddDoctor() {
		assertTrue(DoctorService.getReference().addDoctor("DoctorName2", "DOCID"));
		assertTrue(DoctorService.getReference().addDoctor("DoctorName",  "DOCID2"));
		assertTrue(DoctorService.getReference().addDoctor("DoctorName3", "DOCID3"));
	}
	

	@Test
	public final void testGetAllDoctors() {
		assertTrue(DoctorService.getReference().getAllDoctors().equals(doctorList));
	}
	
	
	
	
}
