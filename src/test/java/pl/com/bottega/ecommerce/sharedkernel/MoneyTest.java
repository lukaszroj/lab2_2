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
    double firstValue;
    double secoundValue;

    @Test
    public void multiplyByPositiveNumber() throws Exception {
        money = new Money(200);
        properValue = new Money(400);
        result = money.multiplyBy(2);
        Assert.assertThat(result, is(equalTo(properValue)));
    }

    @Test
    public void multiplyByNegativeNumber() throws Exception {
        money = new Money(200);
        properValue = new Money(-200);
        result = money.multiplyBy(-1);
        Assert.assertThat(result, is(equalTo(properValue)));
    }

    @Test
    public void addWithSameCurrency() throws Exception {
        money = new Money(firstValue, Currency.getInstance("PLN"));
        anotherMoney = new Money(secoundValue, Currency.getInstance("PLN"));

        result = money.add(anotherMoney);

        assertThat(result.getCurrency(), equalTo(money.getCurrency()));
        assertThat(result, equalTo(new Money(firstValue + secoundValue, money.getCurrency())));

    }

    @Test
    public void subtract() throws Exception {

    }

    @Test
    public void getCurrencyCode() throws Exception {

    }

    @Test
    public void getCurrency() throws Exception {

    }

    @Test
    public void greaterThan() throws Exception {

    }

    @Test
    public void lessThan() throws Exception {

    }

    @Test
    public void lessOrEquals() throws Exception {

    }

}