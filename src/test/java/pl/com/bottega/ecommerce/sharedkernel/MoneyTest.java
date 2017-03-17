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
    public void multiplyByZeroNum() {
        Money money = new Money(10);
        Money moneyExpected = new Money(0);
        Money moneyResult = money.multiplyBy(0);

        assertThat(moneyResult, is(moneyExpected));
    }
    @Test
    public void checkDefaultCurrencyForMultiplyByPositiveNum() {
        Money money = new Money(10);
        Money moneyResult = money.multiplyBy(4);

        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test
    public void checkDefaultCurrencyForMultiplyByNegativeNum() {
        Money money = new Money(10);
        Money moneyResult = money.multiplyBy(-4);

        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test
    public void checkSpecialCurrencyForMultiplyByPositiveNum() {
        Money money = new Money(10, Currency.getInstance("USD"));
        Money moneyResult = money.multiplyBy(4);

        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test
    public void checkSpecialCurrencyForMultiplyByNegativeNum() {
        Money money = new Money(10, Currency.getInstance("USD"));
        Money moneyResult = money.multiplyBy(-4);

        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test
    public void addPositiveNumber(){
        Money money = new Money(10);
        Money moneyToAdd = new Money(40);
        Money moneyExpected = new Money(50);
        Money moneyResult = money.add(moneyToAdd);

        assertThat(moneyResult, is(moneyExpected));
    }

    @Test
    public void addNegativeNumber(){
        Money money = new Money(10);
        Money moneyToAdd = new Money(-40);
        Money moneyExpected = new Money(-30);
        Money moneyResult = money.add(moneyToAdd);

        assertThat(moneyResult, is(moneyExpected));
    }

    @Test
    public void addZeroNumber(){
        Money money = new Money(10);
        Money moneyToAdd = new Money(0);
        Money moneyExpected = new Money(10);
        Money moneyResult = money.add(moneyToAdd);

        assertThat(moneyResult, is(moneyExpected));
    }

    @Test
    public void checkAddPositiveNumWithSameCurrency() {
        Money money = new Money(10, Currency.getInstance("USD"));
        Money moneyToAdd = new Money(10, Currency.getInstance("USD"));
        Money moneyExpected = new Money(20, Currency.getInstance("USD"));
        Money moneyResult = money.add(moneyToAdd);

        assertThat(moneyResult, is(moneyExpected));
        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test
    public void checkAddNegativeNumWithSameCurrency() {
        Money money = new Money(10, Currency.getInstance("USD"));
        Money moneyToAdd = new Money(-10, Currency.getInstance("USD"));
        Money moneyExpected = new Money(0);
        Money moneyResult = money.add(moneyToAdd);

        assertThat(moneyResult, is(moneyExpected));
        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkAddPositiveNumWithDiffrentCurrency() {
        Money money = new Money(10, Currency.getInstance("USD"));
        Money moneyToAdd = new Money(10, Currency.getInstance("PLN"));

        Money moneyResult = money.add(moneyToAdd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkAddNegativeNumWithDiffrentCurrency() {
        Money money = new Money(10, Currency.getInstance("USD"));
        Money moneyToAdd = new Money(-10, Currency.getInstance("PLN"));

        Money moneyResult = money.add(moneyToAdd);
    }

    @Test
    public void subtractPositiveNumber(){
        Money money = new Money(90);
        Money moneyToSubtract = new Money(40);
        Money moneyExpected = new Money(50);
        Money moneyResult = money.subtract(moneyToSubtract);

        assertThat(moneyResult, is(moneyExpected));
    }

    @Test
    public void subtractNegativeNumber(){
        Money money = new Money(90);
        Money moneyToSubtract = new Money(-40);
        Money moneyExpected = new Money(130);
        Money moneyResult = money.subtract(moneyToSubtract);

        assertThat(moneyResult, is(moneyExpected));
    }

    @Test
    public void subtractZeroNumber(){
        Money money = new Money(90);
        Money moneyToSubtract = new Money(0);
        Money moneyExpected = new Money(90);
        Money moneyResult = money.subtract(moneyToSubtract);

        assertThat(moneyResult, is(moneyExpected));
    }

    @Test
    public void checkSubtractPositiveNumWithSameCurrency() {
        Money money = new Money(90, Currency.getInstance("USD"));
        Money moneyToSubtract = new Money(40, Currency.getInstance("USD"));
        Money moneyExpected = new Money(50, Currency.getInstance("USD"));
        Money moneyResult = money.subtract(moneyToSubtract);

        assertThat(moneyResult, is(moneyExpected));
        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test
    public void checkSubtractNegativeNumWithSameCurrency() {
        Money money = new Money(90, Currency.getInstance("USD"));
        Money moneyToSubtract = new Money(-40, Currency.getInstance("USD"));
        Money moneyExpected = new Money(130, Currency.getInstance("USD"));
        Money moneyResult = money.subtract(moneyToSubtract);

        assertThat(moneyResult, is(moneyExpected));
        assertThat(moneyResult.getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSubtractPositiveNumWithDiffrentCurrency() {
        Money money = new Money(90, Currency.getInstance("USD"));
        Money moneyToSubtract = new Money(40, Currency.getInstance("PLN"));

        Money moneyResult = money.subtract(moneyToSubtract);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSubtractNegativeNumWithDiffrentCurrency() {
        Money money = new Money(90, Currency.getInstance("USD"));
        Money moneyToSubtract = new Money(-40, Currency.getInstance("PLN"));

        Money moneyResult = money.subtract(moneyToSubtract);
    }

    @Test
    public void greaterThanPositiveNum() {
        Money money = new Money(10);
        Money moneyToCompare = new Money(40);
        boolean moneyResult = money.greaterThan(moneyToCompare);

        assertThat(moneyResult, is(false));
    }

    @Test
    public void greaterThanNegativeNum() {
        Money money = new Money(10);
        Money moneyToCompare = new Money(-40);
        boolean moneyResult = money.greaterThan(moneyToCompare);

        assertThat(moneyResult, is(true));
    }

    @Test
    public void greaterThanBothNegativeNum() {
        Money money = new Money(-10);
        Money moneyToCompare = new Money(-40);
        boolean moneyResult = money.greaterThan(moneyToCompare);

        assertThat(moneyResult, is(true));
    }
}