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

    @Test
    public void addByNegativeNumber(){
        Money money = new Money(150);
        Money moneyAdd = new Money(-100);
        Money moneyExpected = new Money(50);

        Money result = money.add(moneyAdd);
        Assert.assertThat(result, is(equalTo(moneyExpected)));
    }

    @Test
    public void addByNegativeNumberWithCurrency(){
        Money money = new Money(150, "EUR");
        Money moneyAdd = new Money(-100);
        Money moneyExpected = new Money(50, "EUR");

        Money result = money.add(moneyAdd);
        Assert.assertThat(result.getCurrencyCode(), is(equalTo(moneyExpected.getCurrencyCode())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithDifferentCurrency(){
        Money money = new Money(150, Currency.getInstance("EUR"));
        Money money2 = new Money(150, Currency.getInstance("PLN"));

        Money result = money.add(money2);
    }

    @Test
    public void substractByPositiveNumber(){
        Money money = new Money(150);
        Money moneySub = new Money(100);
        Money moneyExpected = new Money(50);

        Money result = money.subtract(moneySub);
        Assert.assertThat(result, is(equalTo(moneyExpected)));
    }

    @Test
    public void substractByNegativeNumber(){
        Money money = new Money(150);
        Money moneySub = new Money(-100);
        Money moneyExpected = new Money(250);

        Money result = money.subtract(moneySub);
        Assert.assertThat(result, is(equalTo(moneyExpected)));
    }

    @Test
    public void substractByNegativeNumberWithCurrency(){
        Money money = new Money(150, "EUR");
        Money moneySub = new Money(-100);
        Money moneyExpected = new Money(50, "EUR");

        Money result = money.subtract(moneySub);
        Assert.assertThat(result.getCurrencyCode(), is(equalTo(moneyExpected.getCurrencyCode())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void substractWithDifferentCurrency(){
        Money money = new Money(150, Currency.getInstance("EUR"));
        Money moneySub = new Money(150, Currency.getInstance("PLN"));

        Money result = money.subtract(moneySub);
    }

    @Test
    public void greaterThanPositiveNumber(){
        Money money = new Money(150);
        Money moneyAdd = new Money(100);

        boolean result = money.greaterThan(moneyAdd);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void greaterThanNegativeNumber(){
        Money money = new Money(150);
        Money money2 = new Money(-100);

        boolean result = money.greaterThan(money2);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void greaterThanWithCurrency(){
        Money money = new Money(150, "PLN");
        Money money2 = new Money(100);

        boolean result = money.greaterThan(money2);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void greaterThanWithTwoNegativeNumber(){
        Money money = new Money(-50);
        Money money2 = new Money(-100);

        boolean result = money.greaterThan(money2);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void lessThanPositiveNumbers(){
        Money money = new Money(150);
        Money money2 = new Money(250);

        boolean result = money.lessThan(money2);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void lessThanNegativeNumbers(){
        Money money = new Money(-150);
        Money money2 = new Money(250);

        boolean result = money.lessThan(money2);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void lessThanNegativeNumbersWithCurrency(){
        Money money = new Money(150, "EUR");
        Money money2 = new Money(250);

        boolean result = money.lessThan(money2);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void lessThanWithTwoNegativeNumber(){
        Money money = new Money(-150);
        Money money2 = new Money(-100);

        boolean result = money.lessThan(money2);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void lessOrEqualsForEqualPositiveNumbers(){
        Money money = new Money(250);
        Money money2 = new Money(250);

        boolean result = money.lessOrEquals(money2);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void lessOrEqualsForEqualNegativeNumbers(){
        Money money = new Money(-250);
        Money money2 = new Money(-250);

        boolean result = money.lessOrEquals(money2);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void lessOrEqualsForEqualNumbersWithCurrency(){
        Money money = new Money(250, "EUR");
        Money money2 = new Money(250);

        boolean result = money.lessOrEquals(money2);
        Assert.assertThat(result, is(true));
    }
}