package lab2_2;

import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;


public class MoneyTest {

	final Money money = new Money(50);
	Money expectedMoney;
	Money actualMoney;
	
	@Test
	public void testMultiplyByDoubleMultiplier() {
		
		expectedMoney = new Money(100);
		double multiplier = 2.0;
		actualMoney = money.multiplyBy(multiplier);
		
		Assert.assertThat(actualMoney, is(expectedMoney));
	}
	
	@Test
	public void testMultiplyByBigDecimalMultiplier() {
		
		expectedMoney = new Money(100);
		BigDecimal multiplier = new BigDecimal(2);
		actualMoney = money.multiplyBy(multiplier);
		
		Assert.assertThat(actualMoney, is(expectedMoney));	
	}
	
	@Test
	public void testAdd() {
		
		expectedMoney = new Money(100);
		actualMoney = money.add(money);
		
		Assert.assertThat(actualMoney, is(expectedMoney));		
	}
	
}

