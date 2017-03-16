package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MoneyTest {

    @Test
    public void testMultiplyBy_PositiveValue_SameCurrency() throws Exception {
        Money money = new Money(100, Currency.getInstance("PLN"));

        Money money2 = money.multiplyBy(5);

        assertThat(money2.getCurrency(), equalTo(money.getCurrency()));
        assertThat(money2, equalTo(new Money(500, money.getCurrency())));
    }

    @Test
    public void testAdd_SameCurrency() throws Exception {
        double val1 = 100;
        double val2 = 12.5;

        Money money = new Money(val1, Currency.getInstance("PLN"));
        Money money2 = new Money(val2, Currency.getInstance("PLN"));

        Money actual = money.add(money2);

        assertThat(actual.getCurrency(), equalTo(money.getCurrency()));
        assertThat(actual, equalTo(new Money(val1 + val2, money.getCurrency())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_DifferentCurrency() throws Exception {
        double val1 = 3.85;
        double val2 = 12.5;

        Money money = new Money(val1, Currency.getInstance("PLN"));
        Money money2 = new Money(val2, Currency.getInstance("EUR"));

        money.add(money2);
    }

    @Test
    public void testSubtract_SameCurrency() throws Exception {
        double val1 = 15;
        double val2 = 4;

        Money money = new Money(val1, Currency.getInstance("PLN"));
        Money money2 = new Money(val2, Currency.getInstance("PLN"));

        Money actual = money.subtract(money2);

        assertThat(actual.getCurrency(), equalTo(money.getCurrency()));
        assertThat(actual, equalTo(new Money(val1 - val2, money.getCurrency())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtract_DifferentCurrency() throws Exception {
        double val1 = 69;
        double val2 = 13;

        Money money = new Money(val1, Currency.getInstance("PLN"));
        Money money2 = new Money(val2, Currency.getInstance("EUR"));

        money.subtract(money2);
    }

    @Test
    public void testGreaterThan_CompatibleCurrency() throws Exception {
        Money money1 = new Money(12.67);
        Money money2 = new Money(135.69);

        boolean actual = money2.greaterThan(money1);

        assertThat(actual, is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGreaterThan_IncompatibleCurrency() throws Exception {
        Money money1 = new Money(135.8);
        Money money2 = new Money(11);

        boolean actual = money1.greaterThan(money2);
    }
}