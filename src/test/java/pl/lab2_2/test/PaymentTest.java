package pl.lab2_2.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

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
		ClientData clientData = new ClientData(Id.generate(), "Jan Kowalski");
		Payment payment = paymentFactory.createPayment(clientData, new Money(20));
		Payment result = payment.rollBack();
		assertThat(result, is(notNullValue()));
	}

}
