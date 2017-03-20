/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package tests;

import java.math.BigDecimal;
import java.util.Currency;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.core.Is.is;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 *
 * @author jankowskirobert
 */
public class TestMoney {

    private final Money EUR10 = new Money(10, "EUR");
    private final Money EUR15 = new Money(15, "EUR");
    private final Money EUR21 = new Money(21, "EUR");
    private final Money USD13 = new Money(13, "USD");
    private final Money USD18 = new Money(18, "USD");
    private final Money USD27 = new Money(27, "USD");

    @Test
    public void testMultiplyEuro() {
        final Money eur10By15 = new Money(150, "EUR");
        assertThat(EUR10.multiplyBy(15), is(eur10By15));

        final Money eur15By15 = new Money(225, Currency.getInstance("EUR"));
        assertThat(EUR15.multiplyBy(new BigDecimal(15)), is(eur15By15));

        final Money eur21by15 = new Money(new BigDecimal(315), Currency.getInstance("EUR"));
        assertThat(EUR21.multiplyBy(15), is(eur21by15));

    }

    @Test
    public void testMultiplyDollar() {
        final Money usd13By15 = new Money(195, "USD");
        assertThat(USD13.multiplyBy(15), is(usd13By15));

        final Money usd18By15 = new Money(new BigDecimal(270), Currency.getInstance("USD"));
        assertThat(USD18.multiplyBy(new BigDecimal(15)), is(usd18By15));

        final Money usd27By15 = new Money(405, Currency.getInstance("USD"));
        assertThat(USD27.multiplyBy(15), is(usd27By15));

    }

    @Test
    public void testCompareEuro() {
        assertThat(EUR10.lessThan(EUR15), is(true));
        assertThat(EUR15.lessThan(EUR21), is(true));
        assertThat(EUR21.greaterThan(EUR15), is(true));
        assertThat(EUR15.lessOrEquals(EUR15), is(true));
    }

    @Test
    public void testCompareDollar() {
        assertThat(USD13.lessThan(USD18), is(true));
        assertThat(USD18.lessThan(USD27), is(true));
        assertThat(USD27.greaterThan(USD13), is(true));
        assertThat(USD18.lessOrEquals(USD18), is(true));
    }

    @Test
    public void testCompareDollarAndEuro() {
        assertThat(USD13.lessThan(EUR15), is(true));
        assertThat(EUR15.lessThan(USD27), is(true));
        assertThat(USD27.greaterThan(USD13), is(true));
        assertThat(USD18.lessOrEquals(new Money(18)), is(true));
    }

    @Test
    public void testSumEuro() {
        final Money EUR25 = new Money(25, Currency.getInstance("EUR"));
        assertThat(EUR10.add(EUR15), is(EUR25));
    }

    @Test
    public void testSumDollar() {
        final Money USD31 = new Money(31, Currency.getInstance("USD"));
        assertThat(USD18.add(USD13), is(USD31));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumMixed() {
        final Money EUR25 = new Money(28, Currency.getInstance("EUR"));
        assertThat(USD13.add(EUR15), is(EUR25));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractMixed() {
        final Money MINUS = new Money(-3, Currency.getInstance("EUR"));
        assertThat(USD18.subtract(EUR21), is(MINUS));
    }

    @Test()
    public void testSubutractEuro() {
        final Money MINUS = new Money(-5, Currency.getInstance("EUR"));
        assertThat(EUR10.subtract(EUR15), is(MINUS));
    }
}
