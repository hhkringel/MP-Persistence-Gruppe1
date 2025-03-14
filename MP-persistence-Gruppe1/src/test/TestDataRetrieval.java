package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import db.ProductDB;
import db.ProductDBIF;
import db.SaleOrderDB;
import db.SaleOrderDBIF;
import model.SaleOrder;
import db.CustomerDB;
import db.CustomerDBIF;

class TestDataRetrieval {
	static ProductDBIF productDB;
	static SaleOrderDBIF saleOrderDB;
	static CustomerDBIF customerDB;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		productDB = new ProductDB();
		saleOrderDB = new SaleOrderDB();
		customerDB = new CustomerDB();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSaleOrderDate() {
		//Arrange
		String expectedDate = "2024-03-10";
		int OrderNo = 1;
		//Act
		LocalDate retrievedDate = saleOrderDB.findSaleOrderByID(OrderNo).getPurchaseDate();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = retrievedDate.format(formatter);
		
		//Assert
		assertEquals("Expected date: " + expectedDate 
				 + "\n Retrieved date: " + formattedString, expectedDate, formattedString);
	}
	
	@Test
	void testCustomerPhoneNo() {
		//Arrange
		String expectedPhoneNo = "88888888";
		//Act
		
		String retrievedPhoneNo = customerDB.findCustomerByPhoneNo(expectedPhoneNo).getPhoneNo();
		

		
		//Assert
		assertEquals("Expected phone number: " + expectedPhoneNo 
				 + "\n Retrieved date: " + retrievedPhoneNo, expectedPhoneNo, retrievedPhoneNo);
	}
	
	@Test
	void testProductBarcode() {
		//Arrange
		String expectedBarcode = "1234567890123";
		//Act
		String retrievedBarcode = productDB.findProductByBarcode(expectedBarcode).getBarcode();
		
		//Assert
		assertEquals("Expected date: " + expectedBarcode 
				 + "\n Retrieved date: " + retrievedBarcode, expectedBarcode, retrievedBarcode);
	}

}
