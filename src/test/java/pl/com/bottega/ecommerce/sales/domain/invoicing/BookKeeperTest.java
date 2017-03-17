package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

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
        Money net = new Money(200);
        final String description = "VAT TAX";
        TaxPolicy taxPolicy = new TaxPolicy() {
            public Tax calculateTax(ProductType productType, Money net) {
                Tax result = new Tax(net, description);
                return result;
            }
        }
    }
}