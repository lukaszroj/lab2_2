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
	 
	 @Test
     public void testAddCase1() {
         Money money1 = new Money(5);
         Money money2 = new Money(25);
 
         Money sumOfMoney = money1.add(money2);
 
         Money result = new Money(30);
 
         assertThat(sumOfMoney, equalTo(result));
     }
	 
	 @Test (expected = IllegalArgumentException.class)
     public void testAddCase2() throws IllegalArgumentException {
         Money money1 = new Money(5, "PLN");
         Money money2 = new Money(25, "USD");
 
         Money sumOfMoney = money1.add(money2);
 
         Money result = new Money(30);
 
         assertThat(sumOfMoney, equalTo(result));
     }
}
