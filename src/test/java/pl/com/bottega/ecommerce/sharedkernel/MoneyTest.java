package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Sasho on 2017-03-19.
 */
public class MoneyTest {

    @Test
    public void testMultiplyBy() throws Exception {
        Money money = new Money(50, "USD");

        Money multipled = money.multiplyBy(2);

        assertThat(multipled, equalTo(new Money(100, "USD")));
        assertThat(multipled.getCurrencyCode(), equalTo("USD"));
    }

    @Test
    public void testAdd_sameCurrency() throws Exception {
        Money money1 = new Money( 75);
        Money money2 = new Money(25);

        Money actualSum = money1.add(money2);

        Money expected = new Money(100);

        assertThat(actualSum, equalTo(expected));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAdd_diffCurrency() throws Exception {
        Money money1 = new Money( 43, "EUR");
        Money money2 = new Money(13.7, "PLN");

        money1.add(money2);
    }

    @Test
    public void testSubtract_sameCurrency() throws Exception {
        Money money1 = new Money( 20);
        Money money2 = new Money(5);

        Money actualSum = money1.subtract(money2);

        Money expected = new Money(15);

        assertThat(actualSum, equalTo(expected));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSubtract_diffCurrency() throws Exception {
        Money money1 = new Money( 13.9, "EUR");
        Money money2 = new Money(12.3, "PLN");

        money1.subtract(money2);
    }

    @Test
    public void testGreaterThan_sameCurrency() throws Exception {
        Money money1 = new Money( 20);
        Money money2 = new Money(5);

        boolean isGreater = money1.greaterThan(money2);

        assertThat(isGreater, is (true));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGreaterThan_diffCurrency() throws Exception {
        Money money1 = new Money( 12.9, "EUR");
        Money money2 = new Money(1, "PLN");

        money1.greaterThan(money2);
    }
}