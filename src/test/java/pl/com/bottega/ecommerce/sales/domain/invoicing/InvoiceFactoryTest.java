package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by pebuls on 23.03.17.
 */
public class InvoiceFactoryTest {


    private Invoice invoice;
    private InvoiceFactory invoiceFactory;


    @Test
    public void createInvoiceFactoryCheckIsNotNull() throws Exception {

        invoiceFactory = new InvoiceFactory();

        invoice = invoiceFactory.create(new ClientData(Id.generate(), "Name Surname"));

        assertThat(invoice, notNullValue());
    }

}