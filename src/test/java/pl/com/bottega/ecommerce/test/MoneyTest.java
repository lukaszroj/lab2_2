package pl.com.bottega.ecommerce.test;

import static org.junit.Assert.*;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import static org.hamcrest.CoreMatchers.*;

public class MoneyTest {
	
	@Test
	public void multiplyByZero() {
		Money value = new Money(5);
		Money expectedResult = new Money(0);
		assertThat(value.multiplyBy(0), is(equalTo(expectedResult)));
	}
}
