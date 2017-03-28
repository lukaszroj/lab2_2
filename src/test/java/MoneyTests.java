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
        Money otherMoney = new Money(new BigDecimal("100"));
        Money actual = MONEY.add(otherMoney);
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void addTestCurrencyMismatch(){
        Money otherMoney = new Money(new BigDecimal("100"),Currency.getInstance("PLN"));
        Money actual = MONEY.add(otherMoney);
    }
    @Test
    public void subtractTest(){
        Money expected = new Money(new BigDecimal("0"));
        Money otherMoney = new Money(new BigDecimal("100"));
        Money actual = MONEY.subtract(otherMoney);
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void subtractTestCurrencyMismatch(){
        Money otherMoney = new Money(new BigDecimal("100"),Currency.getInstance("PLN"));
        Money actual = MONEY.subtract(otherMoney);
    }
    @Test
    public void greaterThanTest(){
        Money otherMoney = new Money(new BigDecimal("10"));
        Assert.assertTrue(MONEY.greaterThan(otherMoney));
    }
    @Test
    public void lessThanTest(){
        Money otherMoney = new Money(new BigDecimal("200"));
        Assert.assertTrue(MONEY.lessThan(otherMoney));
    }
    @Test
    public void lessOrEqualsTest(){
        Money otherMoney = new Money(new BigDecimal("200"));
        Assert.assertTrue(MONEY.lessOrEquals(otherMoney));
        otherMoney = new Money(new BigDecimal("100"));
        Assert.assertTrue(MONEY.lessOrEquals(otherMoney));

    }
}
