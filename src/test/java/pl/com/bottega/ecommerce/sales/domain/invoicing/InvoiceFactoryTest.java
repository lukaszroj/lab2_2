package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Piotrek on 17.03.2017.
 */
public class InvoiceFactoryTest {
    @Test
    public void createMethodTest() throws Exception {
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        ClientData clientData = new ClientData(Id.generate(), "TestUser1");
        Object result = invoiceFactory.create(clientData);

        Assert.assertThat(result, is(instanceOf(Invoice.class)));
    }

}