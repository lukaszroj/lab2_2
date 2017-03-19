package lab2_2;

import static org.junit.Assert.*;
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

}
