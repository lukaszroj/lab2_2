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
	
	
}
