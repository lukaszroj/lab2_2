package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import java.util.Currency;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MoneyTest {

    private final Money USD_MONEY = new Money(100,"USD");
    private final Money EUR_MONEY = new Money(300, "EUR");
    private final Money ANY_MONEY = new Money(300);

    @Test
    public void shouldSetEurAsDefaultCurrency() throws Exception {
        //given:
        final Currency EXPECTED_CURRENCY = Currency.getInstance("EUR");

        //when:
        Money money = new Money(0);

        //then:
        assertThat(money.getCurrency(),is(EXPECTED_CURRENCY));
    }

    @Test
    public void shouldProperlyMultiplyByPositive() throws Exception {
        //given:
        final Money EXPECTED_MONEY = new Money(300);

        //when:
        Money result = ANY_MONEY.multiplyBy(3);

        //then:
        assertThat(result, is(EXPECTED_MONEY));
    }

    @Test
    public void shouldProperlyMultiplyByNegative() throws Exception {
        //given:
        final Money EXPECTED_MONEY = new Money(-300);

        //when:
        Money result = ANY_MONEY.multiplyBy(-3);

        //then:
        assertThat(result, is(EXPECTED_MONEY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForNoncompatibleCurrency() throws Exception {
        //when:
        EUR_MONEY.add(USD_MONEY);
    }

    @Test
    public void shouldAddTwoMoneyObjects() throws Exception {
        //given:
        final Money EXPECTED_MONEY = new Money(600,"EUR");

        //when:
        Money result = EUR_MONEY.add(ANY_MONEY);


        //then:
        assertThat(result,equalTo(EXPECTED_MONEY));
    }

    @Test
    public void shouldSubtractTwoMoneyObjects() throws Exception {
        //given:
        final Money EXPECTED_MONEY = new Money(0,"EUR");

        //when:
        Money result = EUR_MONEY.subtract(ANY_MONEY);


        //then:
        assertThat(result,equalTo(EXPECTED_MONEY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionTryingToSubtractTwoCurrencies() throws Exception {
        //when:
        EUR_MONEY.subtract(USD_MONEY);
    }
}