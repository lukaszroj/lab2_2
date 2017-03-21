package pl.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class PaymentTest {

	@Test
	public void paymentExistTest() {
		PaymentFactory paymentFactory = new PaymentFactory();
		Payment payment = paymentFactory.createPayment(new ClientData(new Id("id"), "clientData"), new Money(50));

		assertThat(payment, is(not(nullValue())));
	}

}
