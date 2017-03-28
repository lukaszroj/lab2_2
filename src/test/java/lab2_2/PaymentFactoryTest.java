package lab2_2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class PaymentFactoryTest {

	@Test
	public void testCreatePayment() {
		PaymentFactory paymentFactory = new PaymentFactory();
		Payment payment = paymentFactory.createPayment(new ClientData(Id.generate(), "Milosz"), new Money(1000));
		
		assertThat(payment, is(instanceOf(Payment.class)));
	}

}
