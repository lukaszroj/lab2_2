package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MoneyTest {

	@Test
	public void multiplyByPositive() {
		Money money = new Money(100);
		Money expected = new Money(200);
		Money result = money.multiplyBy(2);
		Assert.assertThat(result, is(equalTo(expected)));
	}

	@Test
	public void multiplyByZero() {
		Money money = new Money(100);
		Money expected = new Money(0);
		Money result = money.multiplyBy(0);
		Assert.assertThat(result, is(equalTo(expected)));
	}

}
