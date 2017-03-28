package pl.com.bottega.ecommerce.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import static org.hamcrest.CoreMatchers.*;
import java.util.Currency;

public class MoneyTest {
	
	@Test
	public void multiplyByZero() {
		Money value = new Money(5);
		Money expectedResult = new Money(0);
		assertThat(value.multiplyBy(0), is(equalTo(expectedResult)));
	}
	
	@Test
	public void multiplyByPositive() {
		Money value = new Money(5);
		Money expectedResult = new Money(30);
		assertThat(value.multiplyBy(6), is(equalTo(expectedResult)));
	}
	
	@Test
	public void multiplyByNegative() {
		Money value = new Money(5);
		Money expectedResult = new Money(-30);
		assertThat(value.multiplyBy(-6), is(equalTo(expectedResult)));
	}
	
	@Test
	public void multiplyBigDecimalKeepTheSameCurreny() {
		Money value = new Money(5, Currency.getInstance("USD"));
		Money expectedResult = new Money(35, Currency.getInstance("USD"));
		assertThat(value.multiplyBy(7), is(equalTo(expectedResult)));
	}
	
	@Test
	public void addZero() {
		Money value = new Money(5);
		assertThat(value.add(new Money(0)), is(equalTo(value)));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void addDifferentCurrency() throws IllegalArgumentException{
		thrown.expect(IllegalArgumentException.class);
		Money value = new Money(5, Currency.getInstance("PLN"));
		Money added = new Money(5, Currency.getInstance("USD"));		
		value.add(added);
	}
	
	@Test
	public void subtractZero() {
		Money value = new Money(5);
		assertThat(value.subtract(new Money(0)), is(equalTo(value)));
	}
	
	@Test
	public void subtractDifferentCurrency() throws IllegalArgumentException{
		thrown.expect(IllegalArgumentException.class);
		Money value = new Money(5, Currency.getInstance("PLN"));
		Money subtracted = new Money(5, Currency.getInstance("USD"));		
		value.add(subtracted);
	}
	
	@Test
	public void addZeroWithDifferenteCurrecny() {
		Money pln = new Money(5, Currency.getInstance("PLN"));
		Money usd = new Money(0, Currency.getInstance("USD"));
		assertThat(pln.add(usd), is(equalTo(pln)));
	}
	
	@Test
	public void subractZeroWithDifferenteCurrecny() {
		Money pln = new Money(5, Currency.getInstance("PLN"));
		Money usd = new Money(0, Currency.getInstance("USD"));
		assertThat(pln.subtract(usd), is(equalTo(pln)));
	}
	
	@Test
	public void checkCurrenyCode() {
		Money pln = new Money(5, Currency.getInstance("PLN"));
		assertThat(pln.getCurrencyCode(), is(equalTo("PLN")));
	}
	
	@Test
	public void greaterThan() {
		Money more = new Money(8, Currency.getInstance("USD"));
		Money less = new Money(7, Currency.getInstance("GBP"));
		assertThat(more.greaterThan(less), is(equalTo(true)));
	}
}
