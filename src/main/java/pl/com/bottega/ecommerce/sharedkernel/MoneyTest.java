package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Krzysztof Zimny on 4/25/2017.
 */
public class MoneyTest {

    @Test
    public void multiplyByUsingOnlyPositiveNumbersTest() {
        Money money = new Money(1);
        Money result = money.multiplyBy(3);
        Money expectedResult = new Money(3);
        Assert.assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void multiplyByUsingOnlyNegativeNumbersTest() {
        Money money = new Money(-1);
        Money result = money.multiplyBy(-3);
        Money expectedResult = new Money(3);
        Assert.assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void multiplyByUsingMixedNumbersTest() {
        Money money = new Money(-1);
        Money result = money.multiplyBy(3);
        Money expectedResult = new Money(-3);
        Assert.assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void multiplyByZeroTest() {
        Money money = new Money(1);
        Money result = money.multiplyBy(0);
        Money expectedResult = new Money(0);
        Assert.assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void addPositiveNumbersTest() {
        Money money = new Money(1);
        Money moneyToAdd = new Money(2);
        Money result = money.add(moneyToAdd);
        Money expectedResult = new Money(3);
        Assert.assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void addNegativeNumbersTest() {
        Money money = new Money(-1);
        Money moneyToAdd = new Money(-1);
        Money result = money.add(moneyToAdd);
        Money expectedResult = new Money(-2);
        Assert.assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void addMixedNumbersTest() {
        Money money = new Money(1);
        Money moneyToAdd = new Money(-1);
        Money result = money.add(moneyToAdd);
        Money expectedResult = new Money(0);
        Assert.assertThat(result, is(equalTo(expectedResult)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAnotherCurrencyTest() {
        Money money = new Money(1, Currency.getInstance("PLN"));
        Money moneyToAdd = new Money(-1, Currency.getInstance("EUR"));
        Money result = money.add(moneyToAdd);
    }

    @Test
    public void substractPositiveNumbersTest() {
        Money money = new Money(1);
        Money moneyToSubstract = new Money(2);
        Money result = money.subtract(moneyToSubstract);
        Money expectedResult = new Money(-1);
        Assert.assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void substractNegativeNumbersTest() {
        Money money = new Money(-1);
        Money moneyToSubstract = new Money(-1);
        Money result = money.subtract(moneyToSubstract);
        Money expectedResult = new Money(0);
        Assert.assertThat(result, is(equalTo(expectedResult)));
    }
}
