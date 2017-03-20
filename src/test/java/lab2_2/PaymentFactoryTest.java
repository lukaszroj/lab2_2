package lab2_2;
import static org.hamcrest.CoreMatchers.*;


import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class PaymentFactoryTest {

	@Test
	public void testCreate() {
		

		PaymentFactory factory = new PaymentFactory();
		Payment payment = factory.createPayment( new ClientData(Id.generate(), "John Doe"), new Money(50));
	
		Assert.assertThat(payment, instanceOf(Payment.class));
	}
	
}
