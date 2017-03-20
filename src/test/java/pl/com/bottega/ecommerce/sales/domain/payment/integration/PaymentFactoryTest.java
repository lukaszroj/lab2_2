package pl.com.bottega.ecommerce.sales.domain.payment.integration;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by grusz on 15.03.2017.
 */
public class PaymentFactoryTest {

    @Test
    public void createPayment_checkType (){
        Id clientId = Id.generate();
        Money money = new Money(100);
        ClientData data = new ClientData(clientId,"Andrew");
        PaymentFactory factory = new PaymentFactory();
        Payment result = factory.createPayment(data,money);
        Assert.assertThat(result, is(instanceOf(Payment.class)));
    }
}
