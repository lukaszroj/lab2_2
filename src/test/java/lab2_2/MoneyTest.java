package lab2_2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

	@Test
	public void testMultiplyByMethod() {
		Money result = new Money(100);
		final double multiplier = 4;
		final Money testValue = new Money(400);
		
		result = result.multiplyBy(multiplier);
		
		assertThat(result, is(testValue));
	}
	
	@Test
	public void testAddMethod() {
		Money result = new Money(100);
		final Money moneyToAdd = new Money(300);
		final Money testValue = new Money(400);
		
		result = result.add(moneyToAdd);
		
		assertThat(result, is(testValue));
	}
	
	@Test
	public void testSubtractMethod() {
		Money result = new Money(400);
		final Money moneyToSubtract = new Money(300);
		final Money testValue = new Money(100);
		
		result = result.subtract(moneyToSubtract);
		
		assertThat(result, is(testValue));
	}
	
}
