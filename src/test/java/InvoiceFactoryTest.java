import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;

import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Wojciech Szczepaniak on 19.03.2017.
 */
public class InvoiceFactoryTest {

    @Test
    public void createInvoiceHaveExpectedType() {
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        ClientData clientData = new ClientData(Id.generate(), "Test");
        Object result = invoiceFactory.create(clientData);
        Assert.assertThat(result, is(instanceOf(Invoice.class)));
    }
}
