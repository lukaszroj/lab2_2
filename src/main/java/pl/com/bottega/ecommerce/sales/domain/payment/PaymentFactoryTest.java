package pl.com.bottega.ecommerce.sales.domain.payment;

import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class PaymentFactoryTest {

    @Test
    public void createPayment() throws Exception {
        ClientData clientData = new ClientData(Id.generate(), "Agata");
        Money money = new Money(666, "PLN");
        PaymentFactory paymentFactory = new PaymentFactory();
        Payment payment = paymentFactory.createPayment(clientData, money);
        assertThat(payment, notNullValue());
    }
}