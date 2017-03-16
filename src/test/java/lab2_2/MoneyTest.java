package lab2_2;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

	@Test
	public void multiplyByZeroDouble() {
		Money expectation = new Money(0);
		Money reality = new Money(123);
		assertThat(reality.multiplyBy(0.0), is(equalTo(expectation)));
	}
}
