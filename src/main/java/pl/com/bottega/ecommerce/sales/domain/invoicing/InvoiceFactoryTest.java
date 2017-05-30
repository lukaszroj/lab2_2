package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Krzysztof Zimny on 4/25/2017.
 */
public class InvoiceFactoryTest {

    private ClientData clientData;

    @Before
    public void setUp() throws Exception {
        clientData = createClientDataInstance();
    }

    private ClientData createClientDataInstance() {
        return new ClientData(Id.generate(), "Krzysztof Zimny");
    }

    @Test
    public void createInvoiceTest() {
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoice = invoiceFactory.create(clientData);
        Assert.assertThat(invoice, is(instanceOf(Invoice.class)));
    }
}
