package medical.com.medicalApplication.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest {
	
	private static Employee employee;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		employee = new Employee("EmployeeName", "EMP4567");
	
	}

	@Test
	public final void testGetName() {
		assertTrue(employee.getName().equals("EmployeeName"));
		
	}

	@Test
	public final void testGetId() {
		
		assertTrue(employee.getId().equals("EMP4567"));
		
	}
	
	@Test
	public final void testGetPassword() {
		
		assertTrue(employee.getPassword().equals("Open"));
		
	}
	
	}

