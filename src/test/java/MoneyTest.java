import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Piotr on 17.03.2017.
 */
public class MoneyTest {

    @Test
    public void multiplyByMoney() {
        final Money EXPECTED_MONEY = new Money(20);
        Money money = new Money(10);

        Money resultMoney = money.multiplyBy(2);

        assertThat(resultMoney,is(EXPECTED_MONEY));
    }
}
