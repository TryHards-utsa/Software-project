package application.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import application.model.Customer;
import application.model.Item;

public class CustomerTest {
	Customer customer;
	ArrayList<Item> cart;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cart = new ArrayList<>();
		customer = new Customer("Bill","password123","1111","y@gmail.com",cart);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Before
	public void testAddItemToCart() {
		Item itm = new Item("Banana",33.30);
		customer.getCart().clear();
		customer.addItemToCart(itm);
		assertFalse("Item was not added", customer.getCart().isEmpty());
				
	}

	@Test
	public void testRemoveItemFromCart() {
		Item itm = new Item("Banana",33.30);
		customer.getCart().clear();
		customer.addItemToCart(itm);
		customer.removeItemFromCart(itm);
		assertTrue("Item was not removed", customer.getCart().isEmpty());
	}
	
	
}
