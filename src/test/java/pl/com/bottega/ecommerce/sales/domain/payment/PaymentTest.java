package pl.com.bottega.ecommerce.sales.domain.payment;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Patryk Wierzyński
 */

public class PaymentTest {
	@Test
	public void rollBack() throws Exception {
		PaymentFactory paymentFactory = new PaymentFactory();
		ClientData clientData = new ClientData(Id.generate(), "Test");
		Payment payment = paymentFactory.createPayment(clientData, new Money(50));
		Payment result = payment.rollBack();
		assertThat(result, is(notNullValue()));
	}

}