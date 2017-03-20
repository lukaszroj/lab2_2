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

	@Test
	public void addMoneyTest() {

		Money money = new Money(22.2);
		Money money2 = new Money(27.8);

		assertThat(money.add(money2), is(equalTo(new Money(50))));
	}

	@Test
	public void subtractMoneyTest() {

		Money money = new Money(50);
		Money money2 = new Money(27.8);

		assertThat(money.subtract(money2), is(equalTo(new Money(22.2))));
	}
	
	@Test
	public void greaterThanTest() {

		Money money = new Money(50);
		Money money2 = new Money(27.8);

		assertThat(money.greaterThan(money2), is(true));
	}
	
	@Test
	public void lessThanTest() {

		Money money = new Money(20);
		Money money2 = new Money(27.8);

		assertThat(money.lessThan(money2), is(true));
	}

}
