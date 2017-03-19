import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Currency;

public class MoneyTests {
    Money MONEY = new Money(new BigDecimal("100"));

    @Test
    public void isDefaultCurrencyEUR(){
        Assert.assertEquals(Currency.getInstance("EUR"), MONEY.getCurrency());
    }
    @Test
    public void multiplyByBigDecimalMultiplier(){
        Money expected = new Money(new BigDecimal("1000"));
        Money actual = MONEY.multiplyBy(new BigDecimal("10"));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void multiplyByDoubleMultiplier(){
        Money expected = new Money(new BigDecimal("1000"));
        Money actual = MONEY.multiplyBy(10.0);
        Assert.assertEquals(expected ,actual);
    }
    @Test
    public void addTest(){
        Money expected = new Money(new BigDecimal("200"));
        Money money2 = new Money(new BigDecimal("100"));
        Money actual = MONEY.add(money2);
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void addTestCurrencyMismatch(){
        Money money2 = new Money(new BigDecimal("100"),Currency.getInstance("PLN"));
        Money actual = MONEY.add(money2);
    }
    @Test
    public void subtractTest(){
        Money expected = new Money(new BigDecimal("0"));
        Money money2 = new Money(new BigDecimal("100"));
        Money actual = MONEY.subtract(money2);
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void subtractTestCurrencyMismatch(){
        Money money2 = new Money(new BigDecimal("100"),Currency.getInstance("PLN"));
        Money actual = MONEY.subtract(money2);
    }
}
