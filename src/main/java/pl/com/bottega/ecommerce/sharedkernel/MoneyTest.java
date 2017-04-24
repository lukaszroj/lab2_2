package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;
import java.util.Currency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
}