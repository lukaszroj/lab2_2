import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: Klaudia
 */
public class PaymentFactoryTest {
    private ClientData clientData;
    private Money money;

    @Before
    public void setUp() throws Exception {
        clientData = createDummyClientData();
        money = createDummyMoney();
    }

    private Money createDummyMoney() {
        return new Money();
    }

    private ClientData createDummyClientData() {
        return new ClientData();
    }

    @Test
    public void createPayment() throws Exception {
        PaymentFactory paymentFactory = new PaymentFactory();
        Object result = paymentFactory.createPayment(clientData, money);
        assertThat(result, is(instanceOf(Payment.class)));
    }

}