package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;

/**
 * Created by grusz on 16.03.2017.
 */
public class InvoiceFactoryTest {
    @Test public void createInvoice_checkType() {
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        ClientData data = new ClientData(Id.generate(),"Andrew");
        Object result = invoiceFactory.create(data);
        Assert.assertThat(result,is(instanceOf(Invoice.class)));
    }
}
