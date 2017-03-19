import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;


public class InvoiceFactoryTest {
    @Test
    public void IfInvoiceFactoryCreateReturnsInvoice(){
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        ClientData clientData = new ClientData(Id.generate(), "Patryk");
        Object object = invoiceFactory.create(clientData);
        Assert.assertThat(object, is(instanceOf(Invoice.class)));
    }
}
