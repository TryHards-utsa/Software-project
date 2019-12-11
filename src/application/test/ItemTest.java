package application.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import application.model.Item;

public class ItemTest {
	
	private Item testItem;

	@Before
	public void setUp() throws Exception {
		testItem = new Item("bread", 3.0);
	}

	@Test
	public void testToString() {
		assertEquals("-bread------3.0", testItem.toString());
	}
	
	@Test
	public void testGetItemName() {
		assertEquals("bread", testItem.getItemName());
	}
	
	@Test
	public void testSetItemName() {
		testItem.setItemName("candy");
		assertEquals("candy", testItem.getItemName());
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(3.0, testItem.getPrice(), 0);
	}

	@Test
	public void testSetPrice() {
		testItem.setPrice(5.0);
		assertEquals(5.0, testItem.getPrice(), 0);
	}
}
