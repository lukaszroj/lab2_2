package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Patryk Wierzyński
 */

public class MoneyTest {

	@Test
	public void multiplyByPositive() {
		Money money = new Money(50);
		Money expected = new Money(150);
		Money result = money.multiplyBy(3);
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void multiplyByNegative() {
		Money money = new Money(50);
		Money expected = new Money(-150);
		Money result = money.multiplyBy(-3);
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void multiplyByZero() {
		Money money = new Money(50);
		Money expected = new Money(0);
		Money result = money.multiplyBy(0);
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void multiplyCheckDefaultCurrency() {
		Money money = new Money(50);
		Money result = money.multiplyBy(3);
		assertThat(result.getCurrencyCode(), is(equalTo(money.getCurrencyCode())));
	}

	@Test
	public void multiplyCheckNonDefaultCurrency() {
		Money money = new Money(50, Currency.getInstance("CZK"));
		Money result = money.multiplyBy(3);
		assertThat(result.getCurrencyCode(), is(equalTo(money.getCurrencyCode())));
	}

	@Test
	public void addPositive() {
		Money m1 = new Money(50);
		Money m2 = new Money(100);
		Money expected = new Money(150);
		Money result = m1.add(m2);
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void addPositiveAndNegativeResultAboveZero() {
		Money m1 = new Money(100);
		Money m2 = new Money(-50);
		Money expected = new Money(50);
		Money result = m1.add(m2);
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void addPositiveAndNegativeResultBelowZero() {
		Money m1 = new Money(50);
		Money m2 = new Money(-100);
		Money expected = new Money(-50);
		Money result = m1.add(m2);
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void addNegative() {
		Money m1 = new Money(-50);
		Money m2 = new Money(-100);
		Money expected = new Money(-150);
		Money result = m1.add(m2);
		assertThat(result, is(equalTo(expected)));
	}

	@Test (expected = IllegalArgumentException.class)
	public void addDifferentCurrency() {
		Money m1 = new Money(50, Currency.getInstance("PLN"));
		Money m2 = new Money(100, Currency.getInstance("CZK"));
		Money result = m1.add(m2);
	}

	@Test
	public void subtractPositiveResultAboveZero() {
		Money m1 = new Money(100);
		Money m2 = new Money(50);
		Money expected = new Money(50);
		Money result = m1.subtract(m2);
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void subtractPositiveResultBelowZero() {
		Money m1 = new Money(50);
		Money m2 = new Money(100);
		Money expected = new Money(-50);
		Money result = m1.subtract(m2);
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void substractPositiveAndNegative() {
		Money m1 = new Money(100);
		Money m2 = new Money(-50);
		Money expected = new Money(150);
		Money result = m1.subtract(m2);
		assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void subtractNegative() {
		Money m1 = new Money(-50);
		Money m2 = new Money(-100);
		Money expected = new Money(50);
		Money result = m1.subtract(m2);
		assertThat(result, is(equalTo(expected)));
	}

	@Test (expected = IllegalArgumentException.class)
	public void subtractDifferentCurrency() {
		Money m1 = new Money(50, Currency.getInstance("PLN"));
		Money m2 = new Money(100, Currency.getInstance("CZK"));
		Money result = m1.subtract(m2);
	}

}