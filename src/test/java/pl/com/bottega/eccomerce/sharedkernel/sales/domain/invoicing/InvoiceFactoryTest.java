package pl.com.bottega.eccomerce.sharedkernel.sales.domain.invoicing;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;

/**
 * Created by RFran on 21.03.2017.
 */
public class InvoiceFactoryTest {

    @Test
    public void createInvoiceFactory() {
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        ClientData data = new ClientData(Id.generate(), "Kyoshin");
        Object result = invoiceFactory.create(data);
        assertThat(result, is(instanceOf(Invoice.class)));
    }
}
