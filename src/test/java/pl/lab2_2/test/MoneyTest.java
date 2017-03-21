package pl.lab2_2.test;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

	@Test
	public void testMultiplyByPositive() {
		
		Money money = new Money(30);
		Money expected = new Money(90);
		Money result = money.multiplyBy(3);
		assertThat(result, is(equalTo(expected)));
	}
	
	@Test
	public void testMultiplyByNegative() {
		
		Money money = new Money(30);
		Money expected = new Money(-90);
		Money result = money.multiplyBy(-3);
		assertThat(result, is(equalTo(expected)));
	}
	
	@Test
	public void testMultiplyByZero() {
		
		Money money = new Money(30);
		Money expected = new Money(0);
		Money result = money.multiplyBy(0);
		assertThat(result, is(equalTo(expected)));
	}

}
