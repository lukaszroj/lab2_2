package pl.com.bottega.ecommerce.sharedkernel.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

	 @Test
     public void testMultiplyBy() throws Exception {
         Money money = new Money(10, "PLN");
 
         Money multiply = money.multiplyBy(10);
 
         assertThat(multiply, equalTo(new Money(100, "PLN")));
         assertThat(multiply.getCurrencyCode(), equalTo("PLN"));
     }

}
