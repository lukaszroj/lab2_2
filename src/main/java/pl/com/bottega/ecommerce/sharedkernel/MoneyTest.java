package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Krzysztof Zimny on 4/25/2017.
 */
public class MoneyTest {

    @Test
    public void multiplyByTest() {
        Money money = new Money(1);
        Money result = money.multiplyBy(3);
        Money expectedResult = new Money(3);
        Assert.assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void multiplyByZeroTest() {
        Money money = new Money(1);
        Money result = money.multiplyBy(0);
        Money expectedResult = new Money(0);
        Assert.assertThat(result, is(equalTo(expectedResult)));
    }
}
