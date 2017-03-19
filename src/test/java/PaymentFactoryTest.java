import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by Patryk on 2017-03-19.
 */
public class PaymentFactoryTest {
    @Test
    public void IfInvoiceFactoryCreateReturnsInvoice(){
        PaymentFactory paymentFactory = new PaymentFactory();
        ClientData clientData = new ClientData(Id.generate(), "Patryk");
        Object object = paymentFactory.createPayment(clientData,new Money(20));
        Assert.assertThat(object, is(instanceOf(Payment.class)));
    }
}
