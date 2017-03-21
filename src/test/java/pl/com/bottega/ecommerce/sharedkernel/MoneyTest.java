package pl.com.bottega.ecommerce.sharedkernel;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {

	@Test
	public void testMultiplyBy() {
		Money money = new Money(100);
		double multiplier = 5.0;
		
		Assert.assertThat(money.multiplyBy(multiplier), is(equalTo(new Money(500.0))));
	}

}
