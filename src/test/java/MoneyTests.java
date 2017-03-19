import org.junit.Assert;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTests {
    public void isDefaultCurrencyEUR(){
        Money money = new Money(100);
        Assert.assertEquals("EUR", money.getCurrency());
    }
}
