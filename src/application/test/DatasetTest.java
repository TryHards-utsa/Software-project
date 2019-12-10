package application.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import application.model.Customer;
import application.model.Dataset;
import application.model.Item;

public class DatasetTest {
	private Dataset dataObj;
	ArrayList<Item> cart;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dataObj = new Dataset("Stock");//for Test methods
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer("customerName", "address", "password", "email", cart);
		dataObj.addCustomer(customer);
		assertTrue("Customer not added" ,dataObj.getCustomerList().contains(customer));
	}

	@Before
	public void testLoadCustomer() throws IOException {
		dataObj = new Dataset("Customers");
		dataObj.loadCustomer("data/customers.csv");
		assertFalse("Customer List is empty: ",dataObj.getCustomerList().isEmpty());
	}

	@Before
	public void testLoadItems() throws IOException {
		dataObj = new Dataset("Grocery");
		dataObj.loadItems("csv/items.csv");
		assertFalse("Item List is empty: ",dataObj.getItemsList().isEmpty());
	}
	
	@Before
	public void testLoadDrivers() throws IOException {
		dataObj = new Dataset("drivers");
		dataObj.loadDrivers("csv/drivers.csv");
		assertFalse("Driver List is empty: ",dataObj.getDriversList().isEmpty());
	}

	@Test
	public void testGetCustomerList() {
		ArrayList<Customer> custmList = null;
		custmList = dataObj.getCustomerList();
		assertFalse("Customers List was not fetched",custmList == null);
	}

	@Test
	public void testGetItemsList() {
		ArrayList<Customer> custmList = null;
		custmList = dataObj.getCustomerList();
		assertFalse("Customers List was not fetched",custmList == null);
		ArrayList<Item> itmList = null;
		itmList = dataObj.getItemsList();
		assertFalse("Item List was not fetched",itmList == null);
	}
	
	@Test
	public void testAddItems() {
		Item itm = new Item("Apple", 22.50);
		dataObj.getItemsList().add(itm);
		assertTrue("Item not added" ,dataObj.getItemsList().contains(itm));
		
	}
	

}
