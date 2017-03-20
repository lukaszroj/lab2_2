package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by grusz on 16.03.2017.
 */
public class BookKeeperTest {
    @Test public void publiciseBook_checkTaxValue(){
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        ClientData data = new ClientData(Id.generate(),"Andrew");
        InvoiceRequest request = new InvoiceRequest(data);
        Invoice invoice = invoiceFactory.create(request.getClientData());
        TaxPolicy taxPolicy = new TaxPolicy() {
            public Tax calculateTax(ProductType productType, Money net) {
                Tax result = new Tax(new Money(100),"mock Tax");
                return result;
            }
        };

        for (RequestItem item : request.getItems()) {
            Money net = item.getTotalCost();
            Tax tax = taxPolicy.calculateTax(item.getProductData().getType(),
                    net);
            Assert.assertThat(tax.getAmount(),is(equalTo(new Money(100))));

            InvoiceLine invoiceLine = new InvoiceLine(item.getProductData(),
                    item.getQuantity(), net, tax);
            Assert.assertThat(invoiceLine.getTax().getAmount(),is(equalTo(new Money(100))));
            invoice.addItem(invoiceLine);
        }
    }
}
