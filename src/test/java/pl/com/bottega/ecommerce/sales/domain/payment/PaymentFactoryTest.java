package pl.com.bottega.ecommerce.sales.domain.payment;

import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Sasho on 2017-03-19.
 */
public class PaymentFactoryTest {

    @Test
    public void testCreatePayment() throws Exception {
        ClientData clientData = new ClientData(Id.generate(), "Ania");
        Money money = new Money(1000, "PLN");

        PaymentFactory paymentFactory = new PaymentFactory();
        Payment payment = paymentFactory.createPayment(clientData, money);

        assertThat(payment, notNullValue());
    }
}