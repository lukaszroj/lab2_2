package pl.lab2_2.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class PaymentFactoryTest {

	@Test
	public void createPaymentHasExpectedType() throws Exception {
		
		PaymentFactory paymentFactory = new PaymentFactory();
		ClientData clientData = new ClientData(Id.generate(), "testowa");
		Money money = new Money(500);
		Payment result = paymentFactory.createPayment(clientData, money);
		assertThat(result, is(instanceOf(Payment.class)));
	}

}
