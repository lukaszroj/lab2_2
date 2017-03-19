package pl.com.bottega.ecommerce.sales.domain.payment;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class PaymentFactoryTest {

    private ClientData clientData;
    private PaymentFactory factory;

    @Before
    public void setUp() throws Exception {
        clientData = new ClientData(Id.generate(), "John Doe");
        factory = new PaymentFactory();
    }

    @Test
    public void testCreate_NotNull() throws Exception {
        Payment payment = factory.createPayment(clientData, new Money(15));
        assertThat(payment, notNullValue());
    }
}