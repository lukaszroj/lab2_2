package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class InvoiceFactoryTest {

    private Invoice invoice;
    private InvoiceFactory invoiceFactory;

    @Test
    public void createInvoiceFactoryNotNull() throws Exception {
        invoiceFactory = new InvoiceFactory();
        invoice = invoiceFactory.create(new ClientData(Id.generate(), "Agata Lis-Marciniak"));
        assertThat(invoice, notNullValue());
    }

}