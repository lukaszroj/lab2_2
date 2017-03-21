package pl.lab2_2.test;

import static org.junit.Assert.*;

import java.util.Currency;

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
	
	@Test
	public void testAddPositive() {
		
		Money money = new Money(30);
		Money money1 = new Money(30);
		Money expected = new Money(60);
		Money result = money.add(money1);
		assertThat(result, is(equalTo(expected)));
	}
	
	@Test
	public void testAddPositiveAndNegative() {
		
		Money money = new Money(30);
		Money money1 = new Money(-30);
		Money expected = new Money(0);
		Money result = money.add(money1);
		assertThat(result, is(equalTo(expected)));
	}
	
	@Test
	public void testAddBothNegative() {
		
		Money money = new Money(-30);
		Money money1 = new Money(-30);
		Money expected = new Money(-60);
		Money result = money.add(money1);
		assertThat(result, is(equalTo(expected)));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addNotSameCurrency() {
		Money m1 = new Money(50, Currency.getInstance("PLN"));
		Money m2 = new Money(100, Currency.getInstance("SK"));
		Money result = m1.add(m2);
	}
	
	@Test
	public void testSubstractPositive() {
		
		Money money = new Money(30);
		Money money1 = new Money(30);
		Money expected = new Money(0);
		Money result = money.subtract(money1);
		assertThat(result, is(equalTo(expected)));
	}
	
	@Test
	public void testSubtractPositiveAndNegative() {
		
		Money money = new Money(30);
		Money money1 = new Money(-30);
		Money expected = new Money(60);
		Money result = money.subtract(money1);
		assertThat(result, is(equalTo(expected)));
	}
	
	@Test
	public void testSubtractBothNegative() {
		
		Money money = new Money(-30);
		Money money1 = new Money(-30);
		Money expected = new Money(0);
		Money result = money.subtract(money1);
		assertThat(result, is(equalTo(expected)));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void subtractNotSameCurrency() {
		Money m1 = new Money(50, Currency.getInstance("PLN"));
		Money m2 = new Money(100, Currency.getInstance("SK"));
		Money result = m1.subtract(m2);
	}

}
