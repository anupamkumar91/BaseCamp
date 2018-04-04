package com.mindtree.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mindtree.entiry.Book;
import com.mindtree.entiry.Purchase;
import com.mindtree.manager.BookStoreSystemManager;

public class BookStoreTest {
	BookStoreSystemManager manager = new BookStoreSystemManager();

	@BeforeClass

	public static void beforeClass() {
		System.out.println("Before class--------");
	}

	@Before
	public void beforeTestCases() {

		System.out.println("Before everey test mehtods------");
	}

	@Test
	public void testDisplayBooks() {
		String expectedCategory = "Technology";
		List<Book> list = manager.checkCategory(expectedCategory);
		String actualCategory = null;
		for (Book b : list) {
			actualCategory = b.getCategoryName();

		}
		assertEquals(expectedCategory, actualCategory);

	}

	@Test
	public void testDisplayBooksInvalidCategory() {
		String expectedCategory = "Management";
		List<Book> list = manager.checkCategory(expectedCategory);
		String actualCategory = null;
		for (Book b : list) {
			actualCategory = b.getCategoryName();
		}
		assertEquals(expectedCategory, actualCategory);
	}

	@Test
	public void testPurchaseBook() {
		int book_Id = 1001;
		String custName = "Anupam";
		String mobile_No = "9900972999";
		Purchase purchase = manager.checkPhAndCheckBookId(book_Id, custName, mobile_No);
		assertEquals(mobile_No, purchase.getCustomerMobileNo());

	}

	@Test
	public void testPurchaseBookInvalidBookId() {
		int book_Id = 1009;
		String custName = "Anupam";
		String mobile_No = "9900972999";
		Purchase purchase = manager.checkPhAndCheckBookId(book_Id, custName, mobile_No);
		assertEquals(mobile_No, purchase.getCustomerMobileNo());
	}

	@Test
	public void testPurchaseBookInvalidMobileNo() {
		int book_Id = 1001;
		String custName = "Anupam";
		String mobile_No = "990097";
		Purchase purchase = manager.checkPhAndCheckBookId(book_Id, custName, mobile_No);
		assertEquals(mobile_No, purchase.getCustomerMobileNo());
	}

	@After
	public void afterTestCases() {

		System.out.println("After every test cases--------");
	}

	@AfterClass
	public static void afterClass() {

		System.out.println("After every class------");
	}
}
