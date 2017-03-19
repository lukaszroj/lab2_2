import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Wojciech Szczepaniak on 19.03.2017.
 */
public class MoneyTest {

    @Test
    public void multiplyByPositiveNumber() {
        Money money = new Money(1000).multiplyBy(2);
        Money expected = new Money(2000);

        Assert.assertThat(money, is(equalTo(expected)));
    }

    @Test
    public void multiplyByNegativeNumber() {
        Money money = new Money(1000).multiplyBy(-2);
        Money expected = new Money(-2000);

        Assert.assertThat(money, is(equalTo(expected)));
    }

    @Test
    public void mutliplyByZero() {
        Money money = new Money(1000).multiplyBy(0);
        Money expected = new Money(0);

        Assert.assertThat(money, is(equalTo(expected)));
    }

    @Test
    public void checkNonDefaultCurrencyCodeAfterMultiplyingIsTheSameThanEalier() {
        Money money = new Money(1000, Currency.getInstance("PLN"));
        Money result = money.multiplyBy(2);

        Assert.assertThat(result.getCurrencyCode(), is(equalTo(money.getCurrencyCode())));
    }

    @Test
    public void checkDefaultCurrencyCodeAfterMultiplyingIsTheSameThanEalier() {
        Money money = new Money(1000);
        Money result = money.multiplyBy(2);

        Assert.assertThat(result.getCurrencyCode(), is(equalTo(money.getCurrencyCode())));
    }

    @Test
    public void addingTwoPositiveValuesOfTheSameCurrency() {
        Money money1 = new Money(1000);
        Money money2 = new Money(1000);
        Money result = money1.add(money2);
        Money expected = new Money(2000);

        Assert.assertThat(result, is(equalTo(expected)));
        Assert.assertThat(result.getCurrencyCode(), allOf(is(equalTo(money1.getCurrencyCode())), is(equalTo(money2.getCurrencyCode()))));
    }

    @Test
    public void addingTwoNegativeValuesOfTheSameCurrency() {
        Money money1 = new Money(-1000);
        Money money2 = new Money(-1000);
        Money result = money1.add(money2);
        Money expected = new Money(-2000);

        Assert.assertThat(result, is(equalTo(expected)));
        Assert.assertThat(result.getCurrencyCode(), allOf(is(equalTo(money1.getCurrencyCode())), is(equalTo(money2.getCurrencyCode()))));
    }

    @Test
    public void addingPositiveAndNegativeValuesOfTheSameCurrency() {
        Money money1 = new Money(-1000);
        Money money2 = new Money(2000);
        Money result = money1.add(money2);
        Money expected = new Money(1000);

        Assert.assertThat(result, is(equalTo(expected)));
        Assert.assertThat(result.getCurrencyCode(), allOf(is(equalTo(money1.getCurrencyCode())), is(equalTo(money2.getCurrencyCode()))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionThenAddTwoValuesOfDifferentCurrencies() {
        Money money1 = new Money(1000, Currency.getInstance("EUR"));
        Money money2 = new Money(1000, Currency.getInstance("PLN"));
        Money result = money1.add(money2);
    }

    @Test
    public void subtractTwoPositiveValuesOfTheSameCurrency() {
        Money money1 = new Money(2000);
        Money money2 = new Money(1000);
        Money result = money1.subtract(money2);
        Money expected = new Money(1000);

        Assert.assertThat(result, is(equalTo(expected)));
        Assert.assertThat(result.getCurrencyCode(), allOf(is(equalTo(money1.getCurrencyCode())), is(equalTo(money2.getCurrencyCode()))));
    }

    @Test
    public void subtractTwoNegativeValuesOfTheSameCurrency() {
        Money money1 = new Money(-2000);
        Money money2 = new Money(-1000);
        Money result = money1.subtract(money2);
        Money expected = new Money(-1000);

        Assert.assertThat(result, is(equalTo(expected)));
        Assert.assertThat(result.getCurrencyCode(), allOf(is(equalTo(money1.getCurrencyCode())), is(equalTo(money2.getCurrencyCode()))));
    }

    @Test
    public void subtractPositiveAndNegativeValuesOfTheSameCurrency() {
        Money money1 = new Money(-1000);
        Money money2 = new Money(2000);
        Money result = money1.subtract(money2);
        Money expected = new Money(-3000);

        Assert.assertThat(result, is(equalTo(expected)));
        Assert.assertThat(result.getCurrencyCode(), allOf(is(equalTo(money1.getCurrencyCode())), is(equalTo(money2.getCurrencyCode()))));
    }
}
