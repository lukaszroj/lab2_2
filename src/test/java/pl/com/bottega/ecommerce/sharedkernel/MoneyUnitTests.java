package pl.com.bottega.ecommerce.sharedkernel;

import static org.junit.Assert.*;

import java.util.Currency;

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
	
	@Test
	public void multiplyByNegativeNumber() {
		Money money = new Money(100).multiplyBy(-5);
		Money positiveResult = new Money(-500);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void multiplyByZero() {
		Money money = new Money(100).multiplyBy(0);
		Money positiveResult = new Money(0);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void addingTwoPositiveNumbers() {
		Money money = new Money(100).add(new Money(100));
		Money positiveResult = new Money(200);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void substractionTwoPositiveNumbers() {
		Money money = new Money(100).subtract(new Money(50));
		Money positiveResult = new Money(50);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void addingTwoNegativeNumbers() {
		Money money = new Money(-100).add(new Money(-100));
		Money positiveResult = new Money(-200);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void substractionTwoNegativeNumbers() {
		Money money = new Money(-100).subtract(new Money(-50));
		Money positiveResult = new Money(-50);
		
		assertThat(money.equals(positiveResult), is(true));
	}
	
	@Test
	public void multiplyByPositiveNumberWithPlCurrency() {
		Money money = new Money(500, "PL");
		
		Money positiveResult = money.multiplyBy(2);
		
		assertThat(positiveResult.getCurrencyCode(), is(equalTo("PL")));
	}
	
	@Test
	public void multiplyByPositiveNumberDefaultCurrency() {
		Money money = new Money(500);
		
		Money positiveResult = money.multiplyBy(2);
		
		assertThat(positiveResult.getCurrencyCode(), is(equalTo("EUR")));
	}
	
	@Test
	public void additionTwoPositiveNumbersWithDefaultCurrency() {
		Money money = new Money(500);
		Money money2 = new Money(500);
		Money result = money.add(money2);
		
		assertThat(result.getCurrencyCode(), is(equalTo("EUR")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void additionTwoNumbersWithDifferentCurrency() {
		Money money1 = new Money(500, Currency.getInstance("EUR"));
		Money money2 = new Money(500, Currency.getInstance("PLN"));
		Money result = money1.add(money2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void substractionTwoNumbersWithDifferentCurrency() {
		Money money1 = new Money(500, Currency.getInstance("EUR"));
		Money money2 = new Money(500, Currency.getInstance("PLN"));
		Money result = money1.add(money2);
	}
	
	@Test
	public void isGreaterThanCorrect() {
		Money money1 = new Money(100);
		Money money2 = new Money(50);
	
	    boolean isGreater = money1.greaterThan(money2);

        assertThat(isGreater, is(true));
     }
	
	@Test
    public void isLessThanCorrect() {
	     Money money1 = new Money(50);
	     Money money2 = new Money(100);
	
	     boolean isLess = money1.lessThan(money2);
		 assertThat(isLess, is(true));
	 }
	
	@Test
    public void isLessOrEqualsCorrectWithDifferentValues() {
         Money money1 = new Money(50);
         Money money2 = new Money(100);
 
         boolean isLessOrEquals = money1.lessOrEquals(money2);
 
         assertThat(isLessOrEquals, is(true));
    }
	
	@Test
	   public void isLessOrEqualsWithSameValues() {
	       Money money1 = new Money(100);
	        Money money2 = new Money(100);
	
      boolean isLessOrEquals = money1.lessOrEquals(money2);

      assertThat(isLessOrEquals, is(true));
  }
	
}
