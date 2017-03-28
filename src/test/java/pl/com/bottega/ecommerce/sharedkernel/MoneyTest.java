package pl.com.bottega.ecommerce.sharedkernel;

import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {

	private final Money money = new Money(100, "EUR");
	
	@Test
	public void testMultiplyByDoubleMultiplier() {
		double multiplier = 5.0;
		
		Assert.assertThat(money.multiplyBy(multiplier), is(equalTo(new Money(500.0))));
	}
	
	@Test
	public void testMultiplyByBigDecimalMultiplier() {
		BigDecimal multiplier = new BigDecimal("6.0");
		
		Assert.assertThat(money.multiplyBy(multiplier), is(equalTo(new Money(600.0))));
	}
	
	@Test
	public void testAdd() {
		Assert.assertThat(money.add(new Money(500.0)), is(equalTo(new Money(600.0))));
	}
	
	@Test
	public void testAddNegative() {
		Assert.assertThat(money.add(new Money(-500.0)), is(equalTo(new Money(-400.0))));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddWithUncompatibleCurrency() {
		money.add(new Money(500.0, "USD"));
	}
	
	@Test
	public void testSubtract() {
		Assert.assertThat(money.subtract(new Money(50.0)), is(equalTo(new Money(50.0))));
	}
	
	@Test
	public void testSubtractNegative() {
		Money money = new Money(100);
		
		Assert.assertThat(money.subtract(new Money(-50.0)), is(equalTo(new Money(150.0))));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSubtractWithUncompatibleCurrency() {
		money.subtract(new Money(50.0, "USD"));
	}
	
	@Test
	public void testGreaterThan() {
		Money otherMoney = new Money(50);
		Assert.assertThat(money.greaterThan(otherMoney), is(true));
	}
	
	@Test
	public void testLessThan() {
		Money otherMoney = new Money(500.0);
		Assert.assertThat(money.lessThan(otherMoney), is(true));
	}
	
	@Test
	public void testLessOrEquals() {
		Money otherMoney = new Money(101.0);
		Assert.assertThat(money.lessOrEquals(otherMoney), is(true));
	}
	

}
