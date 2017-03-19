package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * User: Klaudia
 */
public class MoneyTest {
    @Test
    public void testAddNativeCompatibleMoney() throws Exception {
        //Arrange
        Money money = new Money(-10);
        Money money1 = new Money(-10);
        //Act
        Money expected = new Money(-20);
        //Assert
        assertThat(money.add(money1), is(expected));
    }

}