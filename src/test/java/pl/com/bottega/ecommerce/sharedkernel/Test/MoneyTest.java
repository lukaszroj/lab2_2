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
	 
	 @Test
     public void testSubtractCase1() {
         Money money1 = new Money(25);
         Money money2 = new Money(5);
 
         Money differenceOfMoney = money1.subtract(money2);
 
         Money result = new Money(20);
 
         assertThat(differenceOfMoney, equalTo(result));
     }
	 
	 @Test (expected = IllegalArgumentException.class)
     public void testSubtractCase2() throws IllegalArgumentException {
         Money money1 = new Money(25, "PLN");
         Money money2 = new Money(5, "USD");
 
         Money differenceOfMoney = money1.subtract(money2);
 
         Money result = new Money(30);
 
         assertThat(differenceOfMoney, equalTo(result));
     }
	 
	 @Test
     public void testGreaterThan() {
         Money money1 = new Money(25);
         Money money2 = new Money(5);
 
         boolean isGreater = money1.greaterThan(money2);
 
         assertThat(isGreater, is(true));
     }
	 
	 @Test
     public void testLessThan() {
         Money money1 = new Money(5);
         Money money2 = new Money(25);
 
         boolean isLess = money1.lessThan(money2);
 
         assertThat(isLess, is(true));
     }
	 
	 @Test
     public void testLessEqualCase1() {
         Money money1 = new Money(5);
         Money money2 = new Money(25);
 
         boolean isLessOrEquals = money1.lessOrEquals(money2);
 
         assertThat(isLessOrEquals, is(true));
     }
	 
	 @Test
     public void testLessEqualCase2() {
         Money money1 = new Money(5);
         Money money2 = new Money(5);
 
         boolean isLessOrEquals = money1.lessOrEquals(money2);
 
         assertThat(isLessOrEquals, is(true));
     }
}