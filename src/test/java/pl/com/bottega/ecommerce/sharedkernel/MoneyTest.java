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
	public void multiplyByPossitive() {
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
	public void add() throws Exception {

	}

	@Test
	public void subtract() throws Exception {

	}

	@Test
	public void getCurrencyCode() throws Exception {

	}

	@Test
	public void getCurrency() throws Exception {

	}

	@Test
	public void greaterThan() throws Exception {

	}

	@Test
	public void lessThan() throws Exception {

	}

	@Test
	public void lessOrEquals() throws Exception {

	}

	@Test
	public void equals() throws Exception {

	}

}