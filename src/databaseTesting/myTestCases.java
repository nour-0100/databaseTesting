package databaseTesting;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {
	  WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	Random rand2 = new Random();

	Connection con;
	Statement stmt;
	ResultSet rs;
	
@BeforeTest
public void mySetup () throws SQLException {
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Nour0100");
}
@Test (priority = 3)
public void GetData () throws SQLException {
	stmt = con.createStatement();
	rs = stmt.executeQuery("SELECT * FROM customers where customerNumber = 600");
	while (rs.next()) {
		
		int customerNumber = rs.getInt("customerNumber");
		String customerName = rs.getString("customerName");
		
		System.out.println(customerNumber);
		System.out.println(customerName);
		String FirstName = rs.getString("contactfirstName");
		String LastName= rs.getString("contactLastName");


	
	driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		WebElement FirstNameInputField = driver.findElement(By.id("firstname"));
		WebElement LastNameInputField= driver.findElement(By.id("lastname"));
		FirstNameInputField.sendKeys(FirstName);
		LastNameInputField.sendKeys(LastName);
		
	}
}
@Test (priority = 1)
public void AddDataToTheDatabase () throws SQLException {
	int radnomNumber =  rand.nextInt(8889) * rand2.nextInt(45454);
System.out.println(radnomNumber);	
	String query = "INSERT INTO customers (customerNumber, customerName, contactLastName ,contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) VALUES (600, 'Vintage Bikes Co.', 'wilson' , 'Emily', '987-654-3210', '456 Maple Ave', NULL, 'New York', 'NY', '10001', 'USA', 1504, 75000.00)";


	
	stmt=con.createStatement();
	int rowInserted = stmt.executeUpdate(query);

	System.out.println(rowInserted);
	
	

}
@Test (priority = 2)
	public void update () throws SQLException {
	
	String query = "Update customers set contactFirstName = 'Nourrr' Where customerNumber = 600";
	
	stmt=con.createStatement();
	int rowInserted = stmt.executeUpdate(query);

	System.out.println(rowInserted);
	
		
	}
@ Test (priority = 4)
public void Delete () throws SQLException {
	
		
	String query = "delete from customers where customerNumber = 600";
	stmt=con.createStatement();
	int rowInserted = stmt.executeUpdate(query);

	System.out.println(rowInserted);
}


} 


