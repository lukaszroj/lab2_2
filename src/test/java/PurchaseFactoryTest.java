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
 * Created by Wojciech Szczepaniak on 19.03.2017.
 */
public class PurchaseFactoryTest {

    @Test
    public void createPaymentHaveExpectedType() {
        ClientData clientData = new ClientData(Id.generate(), "Test");
        PaymentFactory factory = new PaymentFactory();
        Payment result = factory.createPayment(clientData, new Money(1000));

        Assert.assertThat(result, is(instanceOf(Payment.class)));
    }
}
