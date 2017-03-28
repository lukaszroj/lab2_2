package pl.com.bottega.ecommerce;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

	@Test
	public void testMultiplyByDouble() {
		
		Money money = new Money(5);
		Money expectedMoney = new Money(20);
		
		Assert.assertThat(money.multiplyBy(4), is(equalTo(expectedMoney)));
	}
	
	@Test
	public void testMultiplyByBigDecimal() {
		
		Money money = new Money(5);
		Money expectedMoney = new Money(20);
		
		Assert.assertThat(money.multiplyBy(new BigDecimal(4)), is(equalTo(expectedMoney)));
	}
	
	@Test
	public void testAdd() {
		
		Money money = new Money(5);
		Money extraMoney = new Money(15);
		Money expectedMoney = new Money(20);
		
		Assert.assertThat(money.add(extraMoney), is(equalTo(expectedMoney)));
	}
	
	@Test
	public void testSubstract() {
		
		Money money = new Money(25);
		Money takenMoney = new Money(5);
		Money expectedMoney = new Money(20);
		
		Assert.assertThat(money.subtract(takenMoney), is(equalTo(expectedMoney)));
	}
	
	@Test
	public void testGreaterThan() {
		
		Money money = new Money(10);
		Money lessMoney = new Money(5);
		Money moreMoney = new Money(15);
		
		Assert.assertThat(money.greaterThan(lessMoney), is(true));
		Assert.assertThat(money.greaterThan(moreMoney), is(false));
	}
	
	@Test
	public void testLessThan() {
		
		Money money = new Money(10);
		Money lessMoney = new Money(5);
		Money moreMoney = new Money(15);
		
		Assert.assertThat(money.lessThan(lessMoney), is(false));
		Assert.assertThat(money.lessThan(moreMoney), is(true));
	}
	
	@Test
	public void testLessOrEquals() {
		
		Money money = new Money(10);
		Money lessMoney = new Money(5);
		Money sameMoney = new Money(10);
		Money moreMoney = new Money(15);
		
		Assert.assertThat(money.lessOrEquals(lessMoney), is(false));
		Assert.assertThat(money.lessOrEquals(sameMoney), is(true));
		Assert.assertThat(money.lessOrEquals(moreMoney), is(true));
	}
}
