package lab2_2;

import java.math.BigDecimal;
import java.util.Currency;

import org.hamcrest.core.IsNot;
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

	@Test
	public void addPositive() {
		Money money = new Money(17);
		Money expectedResult = new Money(33);

		Assert.assertThat(money.add(new Money(16)), is(equalTo(expectedResult)));
	}

	@Test
	public void addNegative() {
		Money money = new Money(18);
		Money expectedResult = new Money(-8);

		Assert.assertThat(money.add(new Money(-26)), is(equalTo(expectedResult)));
	}

	@Test
	public void addTwoNegatives() {
		Money money = new Money(-50);
		Money expectedResult = new Money(-83);

		Assert.assertThat(money.add(new Money(-33)), is(equalTo(expectedResult)));
	}

	@Test
	public void addingKeepsCurrency() {
		Money money = new Money(19, Currency.getInstance("CHF"));
		Money expectedResult = new Money(54, Currency.getInstance("CHF"));

		Assert.assertThat(money.add(new Money(35, Currency.getInstance("CHF"))), is(equalTo(expectedResult)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addingDifferentCurrenciesThrowsException() {
		Money money = new Money(19, Currency.getInstance("JPY"));
		Money expectedResult = new Money(54);

		Assert.assertThat(money.add(new Money(35, Currency.getInstance("KRW"))), is(equalTo(expectedResult)));
	}

	@Test
	public void subtractZero() {
		Money money = new Money(21);
		Money expectedResult = new Money(21);

		Assert.assertThat(money.subtract(new Money(0)), is(equalTo(expectedResult)));
	}

	@Test
	public void subtractPositive() {
		Money money = new Money(22);
		Money expectedResult = new Money(13);

		Assert.assertThat(money.subtract(new Money(9)), is(equalTo(expectedResult)));
	}

	@Test
	public void subtractNegative() {
		Money money = new Money(18);
		Money expectedResult = new Money(47);

		Assert.assertThat(money.subtract(new Money(-29)), is(equalTo(expectedResult)));
	}

	@Test
	public void subtractTwoNegatives() {
		Money money = new Money(-52);
		Money expectedResult = new Money(-41);

		Assert.assertThat(money.subtract(new Money(-11)), is(equalTo(expectedResult)));
	}

	@Test
	public void subtractingKeepsCurrency() {
		Money money = new Money(19, Currency.getInstance("CHF"));
		Money expectedResult = new Money(0, Currency.getInstance("CHF"));

		Assert.assertThat(money.subtract(new Money(19, Currency.getInstance("CHF"))), is(equalTo(expectedResult)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void subtractingDifferentCurrenciesThrowsException() {
		Money money = new Money(19, Currency.getInstance("JPY"));
		Money expectedResult = new Money(0);

		Assert.assertThat(money.subtract(new Money(19, Currency.getInstance("KRW"))), is(equalTo(expectedResult)));
	}

	@Test
	public void greaterThanMethodReturnsTrue() {
		Money money = new Money(87);
		Money testMoney = new Money(86);

		Assert.assertThat(money.greaterThan(testMoney), is(true));
	}

	@Test
	public void greaterThanMethodReturnsFalse() {
		Money money = new Money(86);
		Money testMoney = new Money(87);

		Assert.assertThat(money.greaterThan(testMoney), is(false));
	}

	@Test
	public void lessThanMethodReturnsTrue() {
		Money money = new Money(87);
		Money testMoney = new Money(86);

		Assert.assertThat(money.lessThan(testMoney), is(false));
	}

	@Test
	public void lessThanMethodReturnsFalse() {
		Money money = new Money(86);
		Money testMoney = new Money(87);

		Assert.assertThat(money.lessThan(testMoney), is(true));
	}

	@Test
	public void lessOrEqualsMethodReturnsTrueWhenLess() {
		Money money = new Money(123);
		Money testMoney = new Money(321);

		Assert.assertThat(money.lessOrEquals(testMoney), is(true));
	}

	@Test
	public void lessOrEqualsMethodReturnsTrueWhenEqual() {
		Money money = new Money(99);
		Money testMoney = new Money(99);

		Assert.assertThat(money.lessOrEquals(testMoney), is(true));
	}

	@Test
	public void lessOrEqualsMethodReturnsFalseWhenGreater() {
		Money money = new Money(60000);
		Money testMoney = new Money(32);

		Assert.assertThat(money.lessOrEquals(testMoney), is(false));
	}

	@Test
	public void getCurrencyCodeIsEqual() {
		Money money = new Money(552, Currency.getInstance("PLN"));
		
		Assert.assertThat(money.getCurrencyCode(), is(equalTo(Currency.getInstance("PLN").getCurrencyCode())));
	}
	
	@Test
	public void getCurrencyCodeIsNotEqual() {
		Money money = new Money(525, Currency.getInstance("PLN"));
		
		Assert.assertThat(money.getCurrencyCode(), IsNot.not(equalTo(Currency.getInstance("KRW").getCurrencyCode())));
	}
}
