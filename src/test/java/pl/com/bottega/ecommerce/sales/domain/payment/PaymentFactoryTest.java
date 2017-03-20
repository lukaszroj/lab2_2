package pl.com.bottega.ecommerce.sales.domain.payment;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class PaymentFactoryTest {

    @Test
    public void shouldCreatePaymentInstance() throws Exception {
        //given:
        PaymentFactory paymentFactory = new PaymentFactory();
        final ClientData ANY_CLIENT_DATA = new ClientData(Id.generate(), "someName");
        final Money ANY_MONEY = new Money(0);

        //when:
        Object object = paymentFactory.createPayment(ANY_CLIENT_DATA, ANY_MONEY);

        //then:
        assertThat(object,instanceOf(Payment.class));
    }
}