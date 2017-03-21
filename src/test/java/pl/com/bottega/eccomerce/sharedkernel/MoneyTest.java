package pl.com.bottega.eccomerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by RFran on 21.03.2017.
 */
public class MoneyTest {
    @Test
    public void testAddMoney() {
        final Money entryValue = new Money(100);
        final Money moneyToAdd = new Money(200);
        final Money expectedMoney = new Money(300);

        Money result = entryValue.add(moneyToAdd);
        assertThat(result, is(expectedMoney));
    }

    @Test
    public void testSubtractMoney() {
        final Money entryValue = new Money(500);
        final Money moneyToSubtract = new Money(200);
        final Money expectedMoney = new Money(300);

        Money result = entryValue.subtract(moneyToSubtract);
        assertThat(result, is(expectedMoney));
    }

    @Test
    public void testMultiplyByZero() {
        final Money entryValue = new Money(100);
        final Money expectedMoney = new Money(0);

        Money result = entryValue.multiplyBy(0);
        assertThat(result, is(expectedMoney));

    }
}
