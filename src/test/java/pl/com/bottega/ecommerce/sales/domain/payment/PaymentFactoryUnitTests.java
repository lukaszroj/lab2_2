package pl.com.bottega.ecommerce.sales.domain.payment;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.*;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class PaymentFactoryUnitTests {

		@Test
		public void isCreatePaymentCorrectyType() {
		ClientData clientData = new ClientData(Id.generate(), "Test");
		PaymentFactory factory = new PaymentFactory();
		Payment result = factory.createPayment(clientData, new Money(1000));
	
	    assertThat(result, is(instanceOf(Payment.class)));    
	}
}
