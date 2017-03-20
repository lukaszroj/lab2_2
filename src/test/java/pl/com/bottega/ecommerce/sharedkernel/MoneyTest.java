package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by pebuls on 20.03.17.
 */
public class MoneyTest {

    Money money;
    Money anotherMoney;
    Money properValue;
    Money result;
    double firstValue = 26.5;
    double secondValue = 48.05;
    boolean actual;

    @Test
    public void multiplyByPositiveNumber() throws Exception {
        money = new Money(firstValue);
        properValue = new Money(firstValue*2);
        result = money.multiplyBy(2);
        Assert.assertThat(result, is(equalTo(properValue)));
    }

    @Test
    public void multiplyByNegativeNumber() throws Exception {
        money = new Money(firstValue);
        properValue = new Money(firstValue*(-1));
        result = money.multiplyBy(-1);
        Assert.assertThat(result, is(equalTo(properValue)));
    }

    @Test
    public void addWithSameCurrency() throws Exception {
        money = new Money(firstValue, Currency.getInstance("PLN"));
        anotherMoney = new Money(secondValue, Currency.getInstance("PLN"));

        result = money.add(anotherMoney);

        assertThat(result.getCurrency(), equalTo(money.getCurrency()));
        assertThat(result, equalTo(new Money(firstValue + secondValue, money.getCurrency())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithDifferentCurrency() throws Exception {
        money = new Money(firstValue, Currency.getInstance("PLN"));
        anotherMoney = new Money(secondValue, Currency.getInstance("EUR"));

        result = money.add(anotherMoney);
    }

    @Test
    public void subtractWithSameCurrency() throws Exception {
        money = new Money(firstValue, Currency.getInstance("PLN"));
        anotherMoney = new Money(secondValue, Currency.getInstance("PLN"));

        result = money.subtract(anotherMoney);

        assertThat(result.getCurrency(), equalTo(money.getCurrency()));
        assertThat(result, equalTo(new Money(firstValue - secondValue, money.getCurrency())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractWithDifferentCurrency() throws Exception {
        money = new Money(firstValue, Currency.getInstance("PLN"));
        anotherMoney = new Money(secondValue, Currency.getInstance("EUR"));

        result = money.add(anotherMoney);
    }

    @Test
    public void greaterThanWithSameCurrency() throws Exception {

        money = new Money(firstValue);
        anotherMoney = new Money(secondValue);

        boolean actual = anotherMoney.greaterThan(money);

        assertThat(actual, is(true));
    }

    @Test
    public void lessThan() throws Exception {

    }

    @Test
    public void lessOrEquals() throws Exception {

    }

}