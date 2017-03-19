package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
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
}