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
        Money actual = MONEY.multiplyBy(new BigDecimal("10"));
        Assert.assertEquals(new Money(new BigDecimal("1000")),actual);
    }
    @Test
    public void multiplyByDoubleMultiplier(){
        Money actual = MONEY.multiplyBy(10.0);
        Assert.assertEquals(new Money(new BigDecimal("1000")),actual);
    }
}
