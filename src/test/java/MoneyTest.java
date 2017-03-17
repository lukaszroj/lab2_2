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

    @Test
    public void addMoney() {
        final Money EXPECTED_MONEY = new Money(20);
        Money money1 = new Money(10);
        Money money2 = new Money(10);

        Money resultMoney = money1.add(money2);

        assertThat(resultMoney,is(EXPECTED_MONEY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMoneyThrowException() {
        Money money1 = new Money(10,"USD");
        Money money2 = new Money(10,"PLN");

        money1.add(money2);
    }

    @Test
    public void substractMoney() {
        final Money EXPECTED_MONEY = new Money(20);
        Money money1 = new Money(30);
        Money money2 = new Money(10);

        Money resultMoney = money1.subtract(money2);

        assertThat(resultMoney,is(EXPECTED_MONEY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void substractMoneyThrowException() {
        Money money1 = new Money(20,"USD");
        Money money2 = new Money(10,"PLN");

        money1.add(money2);
    }

    @Test
    public void greaterThanMoney() {
        final boolean EXPECTED_RESULT = true;
        Money money1 = new Money(20);
        Money money2 = new Money(10);

        boolean result = money1.greaterThan(money2);

        assertThat(result, is(EXPECTED_RESULT));
    }
}
