import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Currency;

public class MoneyTests {
    @Test
    public void isDefaultCurrencyEUR(){
        Money money = new Money(100);
        Assert.assertEquals(Currency.getInstance("EUR"), money.getCurrency());
    }
}
