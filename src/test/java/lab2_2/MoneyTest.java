package lab2_2;

import static org.junit.Assert.*;

import java.math.BigDecimal;

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
	public void addTwoNegatives() {
		Money expectation = new Money(-40);
		Money reality = new Money(-20);
		assertThat(reality.add(new Money(-20)), is(equalTo(expectation)));
	}
	
	@Test
	public void addTwoOnePosOneNeg() {
		Money expectation = new Money (0);
		Money reality = new Money(-20);
		assertThat(reality.add(new Money(20)), is(equalTo(expectation)));
	}
}
