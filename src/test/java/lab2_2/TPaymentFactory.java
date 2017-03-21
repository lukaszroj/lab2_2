package lab2_2;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class TPaymentFactory {

	@Test
	public void paymentFactoryCreatesCorrectInstance() {
		PaymentFactory paymentFactory = new PaymentFactory();
		Payment payment = paymentFactory.createPayment(new ClientData(Id.generate(), "Orasu"), new Money(69));

		Assert.assertThat(payment, Matchers.is(Matchers.instanceOf(Payment.class)));
	}

}
