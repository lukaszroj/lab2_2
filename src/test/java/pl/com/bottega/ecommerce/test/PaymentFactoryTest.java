package pl.com.bottega.ecommerce.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Before;

import pl.com.bottega.ecommerce.sharedkernel.Money;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.*;
import pl.com.bottega.ecommerce.sales.domain.payment.*;

public class PaymentFactoryTest {
	
	private Id clientId;
	private String name;
	private Money amount;
	
	@Before
	public void initialize() {
		clientId = Id.generate();
		name = "Name";
		amount = new Money(new BigDecimal(0));
	}
	
	@Test
	public void createPaymentTest() {
		ClientData client = new ClientData(clientId, name);
		PaymentFactory paymentFactory = new PaymentFactory();
		assertThat(paymentFactory.createPayment(client, amount), instanceOf(Payment.class));
	}
}
