package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 18.03.2017.
 */
public class InvoiceFactoryTest {
    @Test
    public void checkClientCreate() throws Exception {
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Object invoice = invoiceFactory.create(clientData);

        assertThat(invoice, is(instanceOf(Invoice.class)));
    }

}