package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Klaudia on 20.03.2017.
 */
public class BookKeeperTest {

    private ClientData clientData;

    @Before
    public void setUp() throws Exception {
        clientData = new ClientData(Id.generate(), "Linus Torvalds");
    }

    class MockTaxPolicy implements TaxPolicy {

        public Tax calculateTax(ProductType productType, Money net) {
            return new Tax(net.multiplyBy(0.2), "Mock");
        }
    }

    @Test
    public void testIssuance() throws Exception {
        BookKeeper bookKeeper = new BookKeeper();
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
        TaxPolicy tax = new MockTaxPolicy();
        ProductData productData = new ProductData(Id.generate(), new Money(10), "apple", ProductType.FOOD,
                new Date());
        RequestItem requestItem = new RequestItem(productData, 2, productData.getPrice().multiplyBy(2));
        invoiceRequest.add(requestItem);
        InvoiceLine expected = new InvoiceLine(productData, 2,new Money(20), tax.calculateTax(productData.getType(),requestItem.getTotalCost()));

        Invoice result = bookKeeper.issuance(invoiceRequest, tax);

        assertThat(result.getItems().get(0), equalTo(expected));

    }

}