package lab2_2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

	@Test
	public void testMultiplyByMethod() {
		final Money givenValue = new Money(100);
		final double multiplier = 4;
		final Money testValue = new Money(400);
		
		Money result = givenValue.multiplyBy(multiplier);
		
		assertThat(result, is(testValue));
	}
	
	@Test
	public void testAddMethod() {
		final Money givenValue = new Money(100);
		final Money moneyToAdd = new Money(300);
		final Money testValue = new Money(400);
		
		Money result = givenValue.add(moneyToAdd);
		
		assertThat(result, is(testValue));
	}
	
	@Test
	public void testSubtractMethod() {
		final Money givenValue = new Money(400);
		final Money moneyToSubtract = new Money(300);
		final Money testValue = new Money(100);
		
		Money result = givenValue.subtract(moneyToSubtract);
		
		assertThat(result, is(testValue));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddMethodToThrowExceotion() {
		final Money givenValue = new Money(100,"USD");
		final Money moneyToAdd = new Money(300);
		
		Money result = givenValue.add(moneyToAdd);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSubtractMethodToThrowException() {
		final Money givenValue = new Money(400,"USD");
		final Money moneyToSubtract = new Money(300);
		
		Money result = givenValue.subtract(moneyToSubtract);
	}
	
	@Test
	public void testGreaterThanMethod() {
		final Money testValueOne = new Money(100);
		final Money testValueTwo = new Money(10);
		
		final boolean result = testValueOne.greaterThan(testValueTwo);
		
		assertThat(result, is(true));
	}
	
	@Test
	public void testLessThanMethod() {
		final Money testValueOne = new Money(10);
		final Money testValueTwo = new Money(100);
		
		final boolean result = testValueOne.lessThan(testValueTwo);
		
		assertThat(result, is(true));
	}
	
	@Test
	public void testLessOrEqualsMethodWhereValuesAreEquals() {
		final Money testValueOne = new Money(100);
		final Money testValueTwo = new Money(100);
		
		final boolean result = testValueOne.lessOrEquals(testValueTwo);
		
		assertThat(result, is(true));
	}
	
	@Test
	public void testLessOrEqualsMethodWhereValueisLess() {
		final Money testValueOne = new Money(10);
		final Money testValueTwo = new Money(100);
		
		final boolean result = testValueOne.lessOrEquals(testValueTwo);
		
		assertThat(result, is(true));
	}
}
