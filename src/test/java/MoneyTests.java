import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Currency;

public class MoneyTests {
    @Test
    public void isDefaultCurrencyEUR(){
        Money money = new Money(100);
        Assert.assertEquals(Currency.getInstance("EUR"), money.getCurrency());
    }

    @Test
    public void multiplyByBigDecimalMultiplier(){
        Money money = new Money(new BigDecimal("100"));
        Money actual = money.multiplyBy(new BigDecimal("10"));
        Assert.assertEquals(new Money(new BigDecimal("1000")),actual);
    }
    @Test
    public void multiplyByDoubleMultiplier(){
        Money money = new Money(new BigDecimal("100"));
        Money actual = money.multiplyBy(10.0);
        Assert.assertEquals(new Money(new BigDecimal("1000")),actual);
    }
}
