package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;
import java.util.Currency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class MoneyTest {

    @Test
    public void multiplyBy() throws Exception {
        Money money = new Money(50, Currency.getInstance("PLN"));
        Money result = money.multiplyBy(2);
        assertThat(result.getCurrency(), equalTo(money.getCurrency()));
        assertThat(result, equalTo(new Money(100, money.getCurrency())));
    }

    @Test
    public void addSameCurrency() throws Exception {
        Money money = new Money(75, Currency.getInstance("PLN"));
        Money result = new Money(25, Currency.getInstance("PLN"));
        Money actual = money.add(result);
        assertThat(actual.getCurrency(), equalTo(money.getCurrency()));
        assertThat(actual, equalTo(new Money(100, money.getCurrency())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDifferentCurrency() throws Exception {
        Money money = new Money(12, Currency.getInstance("PLN"));
        Money result = new Money(3.5, Currency.getInstance("EUR"));
        money.add(result);
    }

    @Test
    public void subtractSameCurrency() throws Exception {
        Money money = new Money(20, Currency.getInstance("PLN"));
        Money result = new Money(10, Currency.getInstance("PLN"));
        Money actual = money.subtract(result);
        assertThat(actual.getCurrency(), equalTo(money.getCurrency()));
        assertThat(actual, equalTo(new Money(10, money.getCurrency())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractDifferentCurrency() throws Exception {
        Money money = new Money(666, Currency.getInstance("PLN"));
        Money result = new Money(69, Currency.getInstance("EUR"));
        money.subtract(result);
    }

    @Test
    public void lessThanSameCurrency() throws Exception {
        Money moneyA = new Money(16, Currency.getInstance("PLN"));
        Money moneyB = new Money(9, Currency.getInstance("PLN"));
        boolean actual = moneyA.lessThan(moneyB);
        assertThat(actual, is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void lessThanDifferentCurrency() throws Exception {
        Money moneyA = new Money(2, Currency.getInstance("PLN"));
        Money moneyB = new Money(26, Currency.getInstance("EUR"));
        moneyA.lessThan(moneyB);
    }

    @Test
    public void greaterThanSameCurrency() throws Exception {
        Money moneyA = new Money(66, Currency.getInstance("PLN"));
        Money moneyB = new Money(234, Currency.getInstance("PLN"));
        boolean actual = moneyB.greaterThan(moneyA);
        assertThat(actual, is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void greaterThanDifferentCurrency() throws Exception {
        Money moneyA = new Money(666, Currency.getInstance("PLN"));
        Money moneyB = new Money(69, Currency.getInstance("EUR"));
        moneyA.greaterThan(moneyB);
    }

    @Test
    public void lessOrEqualSameCurrencyNowLess() throws Exception {
        Money moneyA = new Money(7, Currency.getInstance("PLN"));
        Money moneyB = new Money(13, Currency.getInstance("PLN"));
        boolean actual = moneyA.lessOrEquals(moneyB);
        assertThat(actual, is(true));
    }
}