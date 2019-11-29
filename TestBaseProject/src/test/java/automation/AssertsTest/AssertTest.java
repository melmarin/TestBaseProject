package automation.AssertsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {
	
	private int number1 = 7;
	private int number2 = 5;
	
	@Test
	public void numberTrueTest() {
		Assert.assertTrue(number1==number2+2, "The numbers are different");		
	}
	
	@Test
	public void numberFalseTest() {
		Assert.assertFalse(number1==number2, "The numbers are equal");
	}
	
	@Test
	public void equalNumbersTest() {
		Assert.assertEquals(number1+3, number2+5, "The numbers aren't equals");
	}
	
	@Test
	public void notEqualNumbersTest() {
		Assert.assertNotEquals(number1, number2*2, "The numbers are equal");
	}
	
	@Test
	public void nullObjectTest() {
		Employee employee = new Employee();
		employee = null;
		Assert.assertNull(employee, "This employee is not null");
	}
	
	@Test
	public void notNullObjectTest() {
		Employee employee = new Employee("Em0125","Joel");
		Assert.assertNotNull(employee, "This employee is null");
	}
	
	@Test
	public void sameObjectTest() {
		Employee employee = new Employee("Em0125","Joel");
		Employee employee1 = employee;
		Assert.assertSame(employee, employee1, "This objects are located in different part of memory");
	}
	
	@Test
	public void notSameObjectTest() {
		Employee employee = new Employee("Em0125","Joel");
		Employee employee1 = new Employee("Em0125","Joel");
		Assert.assertNotSame(employee, employee1, "This objects are located in the same part of memory");
	}
	

}
