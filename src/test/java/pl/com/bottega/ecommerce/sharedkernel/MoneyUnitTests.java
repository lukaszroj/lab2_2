package pl.com.bottega.ecommerce.sharedkernel;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class MoneyUnitTests {

	@Test
	public void multiplyByPositiveNumber() {
		Money money = new Money(100).multiplyBy(5);
		Money positiveResult = new Money(500);
		
		assertThat(money.equals(positiveResult), is(true));
	}

}
