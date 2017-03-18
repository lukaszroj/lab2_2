package lab2_2;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

	@Test
	public void multiplyByZeroDouble() {
		Money expectation = new Money(0);
		Money reality = new Money(123);
		assertThat(reality.multiplyBy(0.0), is(equalTo(expectation)));
	}
	
	@Test
	public void multiplyByZeroBigDecimal() {
		Money expectation = new Money(0);
		Money reality = new Money(123);
		assertThat(reality.multiplyBy(new BigDecimal(0.0)), is(equalTo(expectation)));
	}
	
	@Test
	public void multiplyByPositiveDouble() {
		Money expectation = new Money(40);
		Money reality = new Money(20);
		assertThat(reality.multiplyBy(2.0), is(equalTo(expectation)));
	}
	
	@Test
	public void multiplyByPositiveBigDecimal() {
		Money expectation = new Money(40);
		Money reality = new Money(20);
		assertThat(reality.multiplyBy(new BigDecimal(2.0)), is(equalTo(expectation)));
	}
	
	@Test
	public void multiplyByNegativeDouble() {
		Money expectation = new Money(-40);
		Money reality = new Money(20);
		assertThat(reality.multiplyBy(-2.0), is(equalTo(expectation)));
	}
	
	@Test
	public void multiplyByNegativeBigDecimal() {
		Money expectation = new Money(-40);
		Money reality = new Money(20);
		assertThat(reality.multiplyBy(new BigDecimal(-2.0)), is(equalTo(expectation)));
	}
	
	@Test
	public void addZero() {
		Money expectation = new Money(50);
		Money reality = new Money(50);
		assertThat(reality.add(new Money(0)), is(equalTo(expectation)));
	}
	
	@Test
	public void addPositive() {
		Money expectation = new Money(40);
		Money reality = new Money(20);
		assertThat(reality.add(new Money(20)), is(equalTo(expectation)));
	}
	
	@Test
	public void addNegative() {
		Money expectation = new Money(20);
		Money reality = new Money(40);
		assertThat(reality.add(new Money(-20)), is(equalTo(expectation)));
	}
	
	@Test
	public void addTwoOnePosOneNeg() {
		Money expectation = new Money (0);
		Money reality = new Money(-20);
		assertThat(reality.add(new Money(20)), is(equalTo(expectation)));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addException() {
		Money testMoney = new Money(123, Currency.getInstance("EUR"));
		testMoney.add(new Money(123, Currency.getInstance("USD")));
	}
	
	@Test
	public void subPositive() {
		Money expectation = new Money(100);
		Money reality = new Money(200);
		assertThat(reality.subtract(new Money(100)), is(equalTo(expectation)));
	}
	
	@Test
	public void subNegative() {
		Money expectation = new Money(300);
		Money reality = new Money(200);
		assertThat(reality.subtract(new Money(-100)), is(equalTo(expectation)));
	}
	
	@Test
	public void subZero() {
		Money expectation = new Money(100);
		Money reality = new Money(100);
		assertThat(reality.subtract(new Money(0)), is(equalTo(expectation)));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void subException() {
		Money testMoney = new Money(123, Currency.getInstance("EUR"));
		testMoney.subtract(new Money(123, Currency.getInstance("USD")));
	}
	
	@Test
	public void subTwoNegatives() {
		Money expectation = new Money(-100);
		Money reality = new Money(-200);
		assertThat(reality.subtract(new Money(-100)), is(equalTo(expectation)));
	}
	
	@Test
	public void greaterThan() {
		Money testMoney = new Money(123);
		Money testMoney2 = new Money(234);
		assertThat(testMoney2.greaterThan(testMoney), is(equalTo(true)));
	}
}
