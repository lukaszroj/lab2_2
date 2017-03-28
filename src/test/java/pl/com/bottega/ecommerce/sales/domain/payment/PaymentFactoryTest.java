package pl.com.bottega.ecommerce.sales.domain.payment;

import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class PaymentFactoryTest {

	@Test
	public void testPaymentFactory() {
		ClientData client = new ClientData(Id.generate(), "Test");
		Money money = new Money(100, "EUR");
		PaymentFactory paymentFactory = new PaymentFactory();
		Assert.assertThat(paymentFactory.createPayment(client, money), instanceOf(Payment.class));
	}

}
