package lab2_2;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class TMoney {

	@Test
	public void multiplyByZeroDouble() {
		Money money = new Money(5);
		Money expectedResult = new Money(0);

		Assert.assertThat(money.multiplyBy(0), is(equalTo(expectedResult)));
	}

	@Test
	public void multiplyByZeroBigDecimal() {
		Money money = new Money(10);
		Money expectedResult = new Money(0);

		Assert.assertThat(money.multiplyBy(new BigDecimal(0)), is(equalTo(expectedResult)));
	}

	@Test
	public void multiplyByPositiveDouble() {
		Money money = new Money(15);
		Money expectedResult = new Money(45);
		
		Assert.assertThat(money.multiplyBy(3), is(equalTo(expectedResult)));
	}

	@Test
	public void multiplyByPositiveBigDecimal() {
		Money money = new Money(13);
		Money expectedResult = new Money(39);
		
		Assert.assertThat(money.multiplyBy(new BigDecimal(3)), is(equalTo(expectedResult)));
	}
}
