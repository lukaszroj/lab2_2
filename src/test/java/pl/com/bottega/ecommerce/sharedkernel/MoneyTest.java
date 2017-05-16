package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MoneyTest {

	@Test
	public void multiplyByPositive() {
		Money money = new Money(100);
		Money expected = new Money(200);
		Money result = money.multiplyBy(2);
		Assert.assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void multiplyByNegative() {
		Money money = new Money(100);
		Money expected = new Money(-200);
		Money result = money.multiplyBy(-2);
		Assert.assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void multiplyByZero() {
		Money money = new Money(100);
		Money expected = new Money(0);
		Money result = money.multiplyBy(0);
		Assert.assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void defaultCurrency_checkCurrencyCode() {
		Money money = new Money(100);
		Money result = money.multiplyBy(2);
		Assert.assertThat(result.getCurrencyCode(), is(equalTo(money.getCurrencyCode())));
	}

	@Test
	public void subtractPositiveCompatibleMoney() {
		Money money1 = new Money(100);
		Money money2 = new Money(10);
		Money expected = new Money(90);
		Money result = money1.subtract(money2);
		Assert.assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void addPositiveCompatibleMoney() {
		Money money1 = new Money(100);
		Money money2 = new Money(100);
		Money expected = new Money(200);
		Money result = money1.add(money2);
		Assert.assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void addNegativeCompatibleMoney() {
		Money money1 = new Money(-100);
		Money money2 = new Money(-100);
		Money expected = new Money(-200);
		Money result = money1.add(money2);
		Assert.assertThat(result, is(equalTo(expected)));
	}

}
