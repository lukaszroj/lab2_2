package pl.com.bottega.ecommerce.sales.domain.payment;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by pebuls on 23.03.17.
 */
public class PaymentFactoryTest {

    private PaymentFactory paymentFactory;
    private Payment payment;


    @Test
    public void createPaymentCheckIsNotNull() throws Exception {

        paymentFactory = new PaymentFactory();

        payment = paymentFactory.createPayment(new ClientData(Id.generate(), "Name Surname"), new Money(15));
        assertThat(payment, notNullValue());
    }

}