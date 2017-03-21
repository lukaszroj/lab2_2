package lab2_2;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class TMoney {

	@Test
	public void multiplyByZeroDouble() {
		Money money = new Money(5);
		Money expectedResult = new Money(0);

		Assert.assertThat(money.multiplyBy(0), is(equalTo(expectedResult)));
	}

	@Test
	public void multiplyByZeroBigDecimal() {
		Money money = new Money(10);
		Money expectedResult = new Money(0);

		Assert.assertThat(money.multiplyBy(new BigDecimal(0)), is(equalTo(expectedResult)));
	}

	@Test
	public void multiplyByPositiveDouble() {
		Money money = new Money(15);
		Money expectedResult = new Money(45);

		Assert.assertThat(money.multiplyBy(3), is(equalTo(expectedResult)));
	}

	@Test
	public void multiplyByPositiveBigDecimal() {
		Money money = new Money(13);
		Money expectedResult = new Money(39);

		Assert.assertThat(money.multiplyBy(new BigDecimal(3)), is(equalTo(expectedResult)));
	}

	@Test
	public void multiplyByNegativeDouble() {
		Money money = new Money(4);
		Money expectedResult = new Money(-20);

		Assert.assertThat(money.multiplyBy(-5), is(equalTo(expectedResult)));
	}

	@Test
	public void multiplyByNegativeBigDecimal() {
		Money money = new Money(3);
		Money expectedResult = new Money(-6);

		Assert.assertThat(money.multiplyBy(new BigDecimal(-2)), is(equalTo(expectedResult)));
	}

	@Test
	public void multiplyByDoubleKeepsTheSameCurrency() {
		Money money = new Money(20, Currency.getInstance("GBP"));
		Money expectedResult = new Money(40, Currency.getInstance("GBP"));

		Assert.assertThat(money.multiplyBy(2), is(equalTo(expectedResult)));
	}

	@Test
	public void multiplyByBigDecimalKeepsTheSameCurrency() {
		Money money = new Money(25, Currency.getInstance("USD"));
		Money expectedResult = new Money(150, Currency.getInstance("USD"));

		Assert.assertThat(money.multiplyBy(new BigDecimal(6)), is(equalTo(expectedResult)));
	}

	@Test
	public void addZero() {
		Money money = new Money(16);
		Money expectedResult = new Money(16);

		Assert.assertThat(money.add(new Money(0)), is(equalTo(expectedResult)));
	}

}
