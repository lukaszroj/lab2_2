package pl.com.bottega.ecommerce.sharedkernel;

import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {

	@Test
	public void testMultiplyByDoubleMultiplier() {
		Money money = new Money(100);
		double multiplier = 5.0;
		
		Assert.assertThat(money.multiplyBy(multiplier), is(equalTo(new Money(500.0))));
	}
	
	@Test
	public void testMultiplyByBigDecimalMultiplier() {
		Money money = new Money(100);
		BigDecimal multiplier = new BigDecimal("6.0");
		
		Assert.assertThat(money.multiplyBy(multiplier), is(equalTo(new Money(600.0))));
	}
	
	@Test
	public void testAdd() {
		Money money = new Money(100);
		
		Assert.assertThat(money.add(new Money(500.0)), is(equalTo(new Money(600.0))));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddWithUncompatibleCurrency() {
		Money money = new Money(100, "USD");
		money.add(new Money(500.0));
	}
	
	

}
