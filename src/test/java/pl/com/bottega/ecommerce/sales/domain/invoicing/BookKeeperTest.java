package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductDataFactory;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Wojciech Szczepaniak on 19.03.2017.
 */
public class BookKeeperTest {

    @Test
    public void issuanceMethodCalculateCorrectTax() throws IllegalAccessException, InstantiationException {
        BookKeeper bookKeeper = new BookKeeper();
        TaxPolicy taxPolicy = new TaxPolicy() {
            public Tax calculateTax(ProductType productType, Money net) {
                return new Tax(net.multiplyBy(0.2), "Test tax");
            }
        };
        InvoiceRequest invoiceRequest = new InvoiceRequest(new ClientData(Id.generate(), "Test Client"));
        RequestItem requestItem = new RequestItem(new ProductDataFactory().createProductData(new Money(1000), "Test product", ProductType.STANDARD), 1, new Money(1000));
        invoiceRequest.add(requestItem);
        Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);

        Assert.assertThat(invoice.getItems().size(), is(1));
        for (InvoiceLine item : invoice.getItems()) {
            Assert.assertThat(item.getTax().getAmount(), is(equalTo(new Money(200))));
        }
    }
}
