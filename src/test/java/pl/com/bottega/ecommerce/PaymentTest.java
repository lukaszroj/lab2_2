package pl.com.bottega.ecommerce;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class PaymentTest {

	@Test
	public void testRollBack() {
		
		PaymentFactory paymentFactory = new PaymentFactory();
		ClientData clientData = new ClientData(new Id("194972"), "Aleksander Kaczmarczyk");
		Payment payment = paymentFactory.createPayment(clientData, new Money(100));
		Payment expectedPaymentAfterRollBack = paymentFactory.createPayment(clientData, new Money(-100));
		
		Payment paymentAfterRollBack = payment.rollBack();
		Assert.assertThat(paymentAfterRollBack, is(equalTo(expectedPaymentAfterRollBack)));
	}

}
