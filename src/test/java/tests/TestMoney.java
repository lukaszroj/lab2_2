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
        assertThat(EUR15.multiplyBy(15), is(eur15By15));

        final Money eur21by15 = new Money(new BigDecimal(315), Currency.getInstance("EUR"));
        assertThat(EUR21.multiplyBy(15), is(eur21by15));

    }

    @Test
    public void testMultiplyDollar() {
        final Money usd13By15 = new Money(195, "USD");
        assertThat(USD13.multiplyBy(15), is(usd13By15));

        final Money usd18By15 = new Money(new BigDecimal(270), Currency.getInstance("USD"));
        assertThat(USD18.multiplyBy(15), is(usd18By15));

        final Money usd27By15 = new Money(405, Currency.getInstance("USD"));
        assertThat(USD27.multiplyBy(15), is(usd27By15));

    }

}
