package pl.com.bottega.ecommerce.sales.domain.payment;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Piotrek on 17.03.2017.
 */
public class PaymentFactoryTest {
    @Test
    public void createPaymentMethodTest() throws Exception {
        PaymentFactory paymentFactory = new PaymentFactory();
        Id id = Id.generate();
        ClientData clientData = new ClientData(Id.generate(), "TestUser1");
        Money money = new Money(150);

        Payment result = paymentFactory.createPayment(clientData, money);
        Assert.assertThat(result, is(instanceOf(Payment.class)));
    }

}