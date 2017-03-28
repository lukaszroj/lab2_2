package pl.com.bottega.ecommerce.sales.domain.payment;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 18.03.2017.
 */
public class PaymentFactoryTest {
    @Test
    public void checkCreatePayment() throws Exception {
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Money money = new Money(12.4);
        PaymentFactory paymentFactory = new PaymentFactory();
        Object payment = paymentFactory.createPayment(clientData, money);

        assertThat(payment, is(instanceOf(Payment.class)));
    }

}