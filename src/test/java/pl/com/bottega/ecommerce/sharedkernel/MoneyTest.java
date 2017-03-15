package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by grusz on 15.03.2017.
 */
public class MoneyTest {
    @Test public void multiplyByPositive () {
        Money money = new Money(100);
        Money expected = new Money(200);
        Money result = money.multiplyBy(2);
        Assert.assertThat(result,is(equalTo(expected)));
    }

    @Test public void multiplyByNegative () {
        Money money = new Money(100);
        Money expected = new Money(-200);
        Money result = money.multiplyBy(-2);
        Assert.assertThat(result,is(equalTo(expected)));
    }

    @Test public void multiplyByZero () {
        Money money = new Money(100);
        Money expected = new Money(0);
        Money result = money.multiplyBy(0);
        Assert.assertThat(result,is(equalTo(expected)));
    }

    @Test public void multiplyByPositive_defaultCurrency_checkCurrencyCode(){
        Money money = new Money(100);
        Money result = money.multiplyBy(2);
        Assert.assertThat(result.getCurrencyCode(),is(equalTo(money.getCurrencyCode())));
    }

    @Test public void multiplyByPositive_nonDefaultCurrency_checkCurrencyCode(){
        Money money = new Money(100, Currency.getInstance("PLN"));
        Money result = money.multiplyBy(2);
        Assert.assertThat(result.getCurrencyCode(),is(equalTo(money.getCurrencyCode())));
    }

    @Test (expected = IllegalArgumentException.class)
    public void additionExceptionTest() {
        Money money1 = new Money(100,Currency.getInstance("EUR"));
        Money money2 = new Money( 100,Currency.getInstance("PLN"));
        Money result = money1.add(money2);
    }

    @Test public void addPositiveCompatibleMoney(){
        Money money1 = new Money(100);
        Money money2 = new Money(100);
        Money expected = new Money(200);
        Money result = money1.add(money2);
        Assert.assertThat(result,is(equalTo(expected)));
    }

    @Test public void addPositiveAndNegativeCompatibleMoney(){
        Money money1 = new Money(100);
        Money money2 = new Money(-100);
        Money expected = new Money(0);
        Money result = money1.add(money2);
        Assert.assertThat(result,is(equalTo(expected)));
    }

    @Test public void addNegativeCompatibleMoney(){
        Money money1 = new Money(-100);
        Money money2 = new Money(-100);
        Money expected = new Money(-200);
        Money result = money1.add(money2);
        Assert.assertThat(result,is(equalTo(expected)));
    }


}
