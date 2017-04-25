package pl.com.bottega.eccomerce.sharedkernel.sales.domain.payment;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 * Created by RFran on 21.03.2017.
 */
public class TestPaymentFactoryTest {

    @Test
    public void testCreatePayment(){
        PaymentFactory paymentFactory = new PaymentFactory();
        Payment payment = paymentFactory.createPayment(new ClientData(Id.generate(), "Kyoshin"), new Money(100));

        assertThat(payment, is(instanceOf(Payment.class)));
    }

}
