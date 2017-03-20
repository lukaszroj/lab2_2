package pl.com.bottega.ecommerce.sharedkernel;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class MoneyUnitTests {

	@Test
	public void multiplyByPositiveNumber() {
		Money money = new Money(100).multiplyBy(5);
		Money positiveResult = new Money(500);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void multiplyByNegativeNumber() {
		Money money = new Money(100).multiplyBy(-5);
		Money positiveResult = new Money(-500);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void multiplyByZero() {
		Money money = new Money(100).multiplyBy(0);
		Money positiveResult = new Money(0);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void addingTwoPositiveNumbers() {
		Money money = new Money(100).add(new Money(100));
		Money positiveResult = new Money(200);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void substractionTwoPositiveNumbers() {
		Money money = new Money(100).subtract(new Money(50));
		Money positiveResult = new Money(50);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void addingTwoNegativeNumbers() {
		Money money = new Money(-100).add(new Money(-100));
		Money positiveResult = new Money(-200);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void substractionTwoNegativeNumbers() {
		Money money = new Money(-100).subtract(new Money(-50));
		Money positiveResult = new Money(-50);
		
		assertThat(money.equals(positiveResult), is(true));
	}
}
