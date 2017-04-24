package pl.com.bottega.ecommerce.sales.domain.payment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Krzysztof Zimny on 4/24/2017.
 */
public class PaymentFactoryTest {

    private ClientData clientData;
    private Money money;

    @Before
    public void createInitialData() {
        clientData = createClientDataInstance();
        money = createMoneyInstance();
    }

    @Test
    public void createPaymentTest() {
        PaymentFactory factory = new PaymentFactory();
        Payment result = factory.createPayment(clientData, money);
        Assert.assertThat(result, is(instanceOf(Payment.class)));
    }

    private ClientData createClientDataInstance() {
        return new ClientData();
    }

    private Money createMoneyInstance() {
        return new Money();
    }
}
