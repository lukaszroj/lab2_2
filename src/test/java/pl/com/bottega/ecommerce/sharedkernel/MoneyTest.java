package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
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
        Money money = new Money(10, Currency.getInstance("PL"));
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

    @Test
    public void testAddCompatibleMoneyIsZero() throws Exception {
        //Arrange
        Money money = new Money(0);
        Money money1 = new Money(10);
        Money expected = new Money(10);
        //Act
        Money result = money.add(money1);
        //Assert
        assertThat(result, is(expected));
    }

    @Test
    public void testAddDummyMoney() {
        //Arrange
        Money dummyMoney = new Money();
        Money money = new Money(10);
        Money expected = new Money(10);
        //Act
        Money result = money.add(dummyMoney);
        //Assert
        assertThat(result, is(expected));
    }

    @Test
    public void testSubtractNegativeCompatibleMoney() {
        //Arrange
        Money money = new Money(-10);
        Money money1 = new Money(-10);
        Money expected = new Money(0);
        //Act
        Money result = money.subtract(money1);
        //Assert
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractOtherCorrenciesIllegalArgumentException() {
        //Arrange
        Money money = new Money(-10, Currency.getInstance("PL"));
        Money money1 = new Money(-10);
        //Act
        Money result = money.subtract(money1);
    }

    @Test
    public void testSubtractCompatibleMoney() {
        //Arrange
        Money money = new Money(10000);
        Money money1 = new Money(10);
        Money expected = new Money(9990);
        //Act
        Money result = money.subtract(money1);
        //Assert
        assertThat(result, is(expected));
    }

    @Test
    public void testMultiplyBy(){
        //Arrange
        Money money = new Money(1000, "PL");
        BigDecimal multiplier = new BigDecimal(2);
        Money expected = new Money(2000, "PL");
        //Act
        Money result = money.multiplyBy(multiplier);
        //Assert
        assertThat(result, is(expected));
    }

}
