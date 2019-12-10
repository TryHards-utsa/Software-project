package application.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.model.Driver;

public class DriverTest {
	
	private Driver driverTmp;

	@Before
	public void setUp() throws Exception {
		driverTmp = new Driver("Bryan", "available");
	}
	
	@Test
	public void testToString() {
		assertEquals( "-Bryan is currently available",driverTmp.toString() );
	}

	@Test
	public void testGetDriverName() {
		assertEquals("Bryan",driverTmp.getDriverName());
	}
	
	@Test
	public void testSetDriverName() {
		driverTmp.setItemName("John");
		assertEquals("John", driverTmp.getDriverName());
	}
	
	@Test
	public void testGetStatus() {
		assertEquals("available",driverTmp.getStatus());
	}
	
	@Test
	public void testSetStatus() {
		driverTmp.setStatus("unavailable");
		assertEquals("unavailable",driverTmp.getStatus());
	}

}
