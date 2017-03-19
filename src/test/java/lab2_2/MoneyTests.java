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
	
	@Test
	public void testAddSameCurrency() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Money expectedResult = new Money(100, Currency.getInstance("PLN"));
		Assert.assertThat(money.add(new Money(90, Currency.getInstance("PLN"))), is(equalTo(expectedResult)));		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddDifferentCurrency() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Money expectedResult = new Money(100, Currency.getInstance("PLN"));
		Assert.assertThat(money.add(new Money(90, Currency.getInstance("USD"))), is(equalTo(expectedResult)));		
	}
	
	@Test
	public void testSubtractSameCurrency() {
		Money money = new Money(100, Currency.getInstance("PLN"));
		Money expectedResult = new Money(10, Currency.getInstance("PLN"));
		Assert.assertThat(money.subtract(new Money(90, Currency.getInstance("PLN"))), is(equalTo(expectedResult)));		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSubtractDifferentCurrency() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Money expectedResult = new Money(100, Currency.getInstance("PLN"));
		Assert.assertThat(money.subtract(new Money(90, Currency.getInstance("USD"))), is(equalTo(expectedResult)));		
	}
	
	@Test
	public void testGetCurrencyCodeTrue() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Assert.assertThat(money.getCurrencyCode(), is(equalTo(Currency.getInstance("PLN").getCurrencyCode())));		
	}

	@Test
	public void testGetCurrencyCodeFalse() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Assert.assertThat(money.getCurrencyCode(), IsNot.not(equalTo(Currency.getInstance("USD").getCurrencyCode())));		
	}
	
	@Test
	public void testGreaterThanTrue() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Assert.assertThat(money.greaterThan(new Money(5, Currency.getInstance("PLN"))), is(true));		
	}
	
	@Test
	public void testGreaterThanFalse() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Assert.assertThat(money.greaterThan(new Money(15, Currency.getInstance("PLN"))), is(false));
	}
	
	@Test
	public void testLessThanTrue() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Assert.assertThat(money.lessThan(new Money(15, Currency.getInstance("PLN"))), is(true));		
	}
	
	@Test
	public void testLessThanFalse() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Assert.assertThat(money.lessThan(new Money(5, Currency.getInstance("PLN"))), is(false));
	}
	
	@Test
	public void testLessOrEqualsThanTrue() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Assert.assertThat(money.lessOrEquals(new Money(15, Currency.getInstance("PLN"))), is(true));
		Assert.assertThat(money.lessOrEquals(new Money(10, Currency.getInstance("PLN"))), is(true));
	}
	
	@Test
	public void testLessOrEqualsThanFalse() {
		Money money = new Money(10, Currency.getInstance("PLN"));
		Assert.assertThat(money.lessOrEquals(new Money(5, Currency.getInstance("PLN"))), is(false));
	}


}