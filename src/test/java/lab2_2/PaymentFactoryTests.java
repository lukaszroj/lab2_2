package lab2_2;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class PaymentFactoryTests {

	@Test
	public void tests() {
		PaymentFactory paymentFactory = new PaymentFactory();
		Payment payment = paymentFactory.createPayment(new ClientData(Id.generate(), "Piotr Treliñski"), new Money(100));
		Assert.assertThat(payment, is(instanceOf(Payment.class)));
	}

}