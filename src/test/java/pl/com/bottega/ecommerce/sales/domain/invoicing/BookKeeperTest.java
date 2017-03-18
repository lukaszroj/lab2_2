package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 18.03.2017.
 */
public class BookKeeperTest {
    @Test
    public void testIssuance() throws Exception {
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);

        TaxPolicy taxPolicy = new TaxPolicy() {
            public Tax calculateTax(ProductType productType, Money net) {
                Tax tax = new Tax(net.multiplyBy(0.23), "Tax");
                return tax;
            }
        };

        BookKeeper bookKeeper = new BookKeeper();

        Object invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);
        assertThat(invoice, is(instanceOf(Invoice.class)));
    }

}