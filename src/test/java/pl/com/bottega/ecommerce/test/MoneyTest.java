package pl.com.bottega.ecommerce.test;

import static org.junit.Assert.*;
import org.junit.Test;
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
}
