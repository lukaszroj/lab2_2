package lab2_2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

import java.math.BigDecimal;
import java.util.Currency;

import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTests {

	@Test
	public void testMultiplyByPositiveDouble() {
		Money money = new Money(10);
		Money expectedResult = new Money(100);
		Assert.assertThat(money.multiplyBy(10), is(equalTo(expectedResult)));		
	}	
	@Test
	public void testMultiplyByNegativeDouble() {
		Money money = new Money(10);
		Money expectedResult = new Money(-100);
		Assert.assertThat(money.multiplyBy(-10), is(equalTo(expectedResult)));		
	}	
	@Test
	public void testMultiplyByWithSameCurrencyDouble() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Money expectedResult = new Money(100, Currency.getInstance("PLN"));
		Assert.assertThat(money.multiplyBy(10), is(equalTo(expectedResult)));		
	}
	
	@Test
	public void testMultiplyByZeroDouble() {
		Money money = new Money(10);
		Money expectedResult = new Money(0);
		Assert.assertThat(money.multiplyBy(0), is(equalTo(expectedResult)));		
	}
	
	@Test
	public void testMultiplyByPositiveBigDecimal() {
		Money money = new Money(10);
		Money expectedResult = new Money(100);
		Assert.assertThat(money.multiplyBy(new BigDecimal(10.0)), is(equalTo(expectedResult)));		
	}	
	@Test
	public void testMultiplyByNegativeBigDecimal() {
		Money money = new Money(10);
		Money expectedResult = new Money(-100);
		Assert.assertThat(money.multiplyBy(new BigDecimal(-10.0)), is(equalTo(expectedResult)));		
	}	
	@Test
	public void testMultiplyByWithSameCurrencyBigDecimal() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Money expectedResult = new Money(100, Currency.getInstance("PLN"));
		Assert.assertThat(money.multiplyBy(new BigDecimal(10.0)), is(equalTo(expectedResult)));		
	}
	
	@Test
	public void testMultiplyByZeroBigDecimal() {
		Money money = new Money(10);
		Money expectedResult = new Money(0);
		Assert.assertThat(money.multiplyBy(new BigDecimal(0.0)), is(equalTo(expectedResult)));		
	}

}
