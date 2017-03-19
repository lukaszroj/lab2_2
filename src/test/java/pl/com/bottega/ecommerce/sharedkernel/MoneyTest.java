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
}