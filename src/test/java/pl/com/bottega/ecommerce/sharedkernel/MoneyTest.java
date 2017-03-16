package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Piotrek on 16.03.2017.
 */
public class MoneyTest {

    @Test
    public void multiplyByPositiveNumber() throws Exception {
        Money money = new Money(150);
        Money moneyExpected = new Money(300);

        Money result = money.multiplyBy(2);
        Assert.assertThat(result, is(equalTo(moneyExpected)));
    }

    @Test
    public void multiplyByNegativeNumber() throws Exception {
        Money money = new Money(150);
        Money moneyExpected = new Money(-300);

        Money result = money.multiplyBy(-2);
        Assert.assertThat(result, is(equalTo(moneyExpected)));
    }

    @Test
    public void multiplyByZero() throws Exception {
        Money money = new Money(150);
        Money moneyExpected = new Money(0);

        Money result = money.multiplyBy(0);
        Assert.assertThat(result, is(equalTo(moneyExpected)));
    }

    @Test
    public void multiplyByPositiveNumberWithDefaultCurrency(){
        Money money = new Money(150);

        Money result = money.multiplyBy(2);
        Assert.assertThat(result.getCurrencyCode(), is(equalTo(money.getCurrencyCode())));
    }

    @Test
    public void multiplyByPositiveNumberWithNotDefaultCurrency(){
        Money money = new Money(150, Currency.getInstance("EUR"));

        Money result = money.multiplyBy(2);
        Assert.assertThat(result.getCurrencyCode(), is(equalTo(money.getCurrencyCode())));
    }

    @Test
    public void addByPositiveNumber(){
        Money money = new Money(150);
        Money moneyAdd = new Money(100);
        Money moneyExpected = new Money(250);

        Money result = money.add(moneyAdd);
        Assert.assertThat(result, is(equalTo(moneyExpected)));
    }
}