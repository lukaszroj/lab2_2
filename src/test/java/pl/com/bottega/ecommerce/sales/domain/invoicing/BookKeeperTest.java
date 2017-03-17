package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.junit.Assert.*;

/**
 * Created by Piotrek on 17.03.2017.
 */
public class BookKeeperTest {

    @Test
    public void taxCheck(){
        ClientData clientData = new ClientData(Id.generate(), "TestUser1");
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
        Invoice invoice = invoiceFactory.create(invoiceRequest.getClientData());
    }
}