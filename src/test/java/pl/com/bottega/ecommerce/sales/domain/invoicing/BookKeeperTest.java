package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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
        };

        for (RequestItem item : invoiceRequest.getItems()) {
            Money net2 = item.getTotalCost();
            Tax tax = taxPolicy.calculateTax(item.getProductData().getType(),
                    net2);

            Assert.assertThat(tax.getAmount(), is(equalTo(net)));

            InvoiceLine invoiceLine = new InvoiceLine(item.getProductData(),
                    item.getQuantity(), net2, tax);
            invoice.addItem(invoiceLine);
            Assert.assertThat(invoiceLine.getTax(), is(equalTo(net)));
        }
    }
}