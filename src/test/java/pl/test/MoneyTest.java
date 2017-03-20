package pl.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

	@Test
	public void multiplyByTest() {

		Money money = new Money(22.2);
		double multiplier = 5;

		assertThat(money.multiplyBy(multiplier), is(equalTo(new Money(111))));
	}

}
