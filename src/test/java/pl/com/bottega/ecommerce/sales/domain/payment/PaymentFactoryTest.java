package pl.com.bottega.ecommerce.sales.domain.payment;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Patryk Wierzyński
 */

public class PaymentFactoryTest {
	@Test
	public void createPaymentHasExpectedType() throws Exception {
		PaymentFactory paymentFactory = new PaymentFactory();
		ClientData clientData = new ClientData(Id.generate(), "Test");
		Money money = new Money(50);
		Payment result = paymentFactory.createPayment(clientData, money);
		assertThat(result, is(instanceOf(Payment.class)));
	}

}