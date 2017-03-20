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
	
	@Test
	public void testSubtract() {
		
		expectedMoney = new Money(0);
		actualMoney = money.subtract(money);
		
		Assert.assertThat(actualMoney, is(expectedMoney));
	}
	
	@Test
	public void testGreaterThanTrue() {
		
		actualMoney = new Money(60);
		expectedMoney = new Money(50);
		
		Assert.assertThat(actualMoney.greaterThan(expectedMoney), is(true));
	}

	@Test
	public void testGreaterThanFalse() {
		
		actualMoney = new Money(50);
		expectedMoney = new Money(60);
		
		Assert.assertThat(actualMoney.greaterThan(expectedMoney), is(not(true)));
	}
	
	@Test
	public void testLessThanTrue() {
		
		actualMoney = new Money(50);
		expectedMoney= new Money(60);
		
		Assert.assertThat(actualMoney.lessThan(expectedMoney), is(true));
	}
	
	@Test
	public void testLessThanFalse() {
		
		actualMoney = new Money(60);
		expectedMoney= new Money(50);
		
		Assert.assertThat(actualMoney.lessThan(expectedMoney), is(not(true)));
	}
	
	@Test
	public void testLessOrEqualsTrueLess() {
		
		actualMoney = new Money(50);
		expectedMoney = new Money(60);
		
		Assert.assertThat(actualMoney.lessOrEquals(expectedMoney), is(true));
	}
	
	@Test
	public void testLessOrEqualsTrueEquals() {
		
		actualMoney = new Money(50);
		expectedMoney = new Money(50);
		
		Assert.assertThat(actualMoney.lessOrEquals(expectedMoney), is(true));
	}
	
	@Test
	public void testLessOrEqualsFalse() {
		
		actualMoney = new Money(50);
		expectedMoney = new Money(40);
		
		Assert.assertThat(actualMoney.lessOrEquals(expectedMoney), is(not(true)));
	}
}

