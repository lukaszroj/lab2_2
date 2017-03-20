package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Klaudia on 20.03.2017.
 */
public class InvoiceFactoryTest {
    private ClientData clientData;
    @Before
    public void setUp() throws Exception {
        clientData = new ClientData(Id.generate(), "Linus Torvalds");
    }

    @Test
    public void testCreate() throws Exception {
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice result = invoiceFactory.create(clientData);
        assertThat(result, is(instanceOf(Invoice.class)));
    }


}