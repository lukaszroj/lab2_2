package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 16.03.2017.
 */
public class MoneyTest {

    @Test
    public void multiplyByPositiveNum() {
        Money money = new Money(10);
        Money moneyExpected = new Money(40);
        Money moneyResult = money.multiplyBy(4);

        assertThat(moneyResult, is(moneyExpected));
    }

    @Test
    public void multiplyByNegativeNum() {
        Money money = new Money(10);
        Money moneyExpected = new Money(-40);
        Money moneyResult = money.multiplyBy(-4);

        assertThat(moneyResult, is(moneyExpected));
    }

    @Test
    public void checkDefaultCurrencyFormultiplyByPositiveNum() {
        Money money = new Money(10);
        Money moneyResult = money.multiplyBy(4);

        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test
    public void checkDefaultCurrencyFormultiplyByNegativeNum() {
        Money money = new Money(10);
        Money moneyResult = money.multiplyBy(-4);

        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test
    public void checkSpecialCurrencyFormultiplyByPositiveNum() {
        Money money = new Money(10, Currency.getInstance("USD"));
        Money moneyResult = money.multiplyBy(4);

        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test
    public void checkSpecialCurrencyFormultiplyByNegativeNum() {
        Money money = new Money(10, Currency.getInstance("USD"));
        Money moneyResult = money.multiplyBy(-4);

        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

}