package pl.com.bottega.ecommerce.sales.domain.payment.Test;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class PaymentFactoryTest {

	 @Test
	 public void testCreatePayment() throws Exception {
         ClientData clientData = new ClientData(Id.generate(), "Patryk");
         Money money = new Money(500, "PLN");
 
         PaymentFactory paymentFactory = new PaymentFactory();
         Payment payment = paymentFactory.createPayment(clientData, money);
 
         assertThat(payment, notNullValue());
	}
}