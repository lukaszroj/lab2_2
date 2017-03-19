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
	public void testCreatePayment() {
		
		PaymentFactory paymentFactory = new PaymentFactory();
		ClientData clientData = new ClientData(new Id("194972"), "Aleksander Kaczmarczyk");
		Payment payment = paymentFactory.createPayment(clientData, new Money(100));
		
		Assert.assertThat(payment, notNullValue());
		Assert.assertThat(payment, is(instanceOf(Payment.class)));
	}

}
