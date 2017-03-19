package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: Klaudia
 */
public class MoneyTest {
    @Test
    public void testAddNativeCompatibleMoney() throws Exception {
        //Arrange
        Money money = new Money(-10);
        Money money1 = new Money(-10);
        Money expected = new Money(-20);
        //Act
        Money result = money.add(money1);
        //Assert
        assertThat(result, is(expected));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddAnotherCurrencyIllegalArgumentException() throws Exception {
        //Arrange
        Money money = new Money(10, "PL");
        Money money1 = new Money(10);
        Money result = money.add(money1);
    }


    @Test
    public void testAddCompatibleMoney() throws Exception {
        //Arrange
        Money money = new Money(10);
        Money money1 = new Money(10);
        Money expected = new Money(20);
        //Act
        Money result = money.add(money1);
        //Assert
        assertThat(result, is(expected));
    }

}