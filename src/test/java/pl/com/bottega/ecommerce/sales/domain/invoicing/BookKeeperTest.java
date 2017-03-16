package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductDataTestFactory;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class BookKeeperTest {

    private BookKeeper keeper;
    private TaxPolicy policy;
    private ClientData clientData;

    private class MockTaxPolicy implements TaxPolicy {

        public Tax calculateTax(ProductType productType, Money net) {
            return new Tax(net.multiplyBy(0.2), "MockTax");
        }
    }

    @Before
    public void setUp() throws Exception {
        keeper = new BookKeeper();
        policy = new MockTaxPolicy();
        clientData = new ClientData(Id.generate(), "John Doe");
    }

    @Test
    public void testIssuance_LineForEachRequest() throws Exception {
        List<ProductData> items = new ArrayList<ProductData>();
        items.add(ProductDataTestFactory.create(new Money(5), "drink", ProductType.FOOD));
        items.add(ProductDataTestFactory.create(new Money(12), "stuff", ProductType.STANDARD));
        items.add(ProductDataTestFactory.create(new Money(3), "cookie", ProductType.FOOD));

        InvoiceRequest request = new InvoiceRequest(clientData);

        int i = 1;
        for(ProductData data : items) {
            RequestItem item = new RequestItem(data, i, data.getPrice().multiplyBy(i));
            request.add(item);
        }

        Invoice invoice = keeper.issuance(request, policy);

        assertThat(invoice.getItems().size(), equalTo(items.size()));

        for(InvoiceLine line : invoice.getItems()) {
            assertThat(line.getProduct(), isIn(items));
        }
    }

    @Test
    public void testIssuance_CorrectTax() throws Exception {
        RequestItem item = new RequestItem(ProductDataTestFactory.create(new Money(100), "stuff", ProductType.STANDARD), 1, new Money(100));

        InvoiceRequest request = new InvoiceRequest(clientData);
        request.add(item);

        Invoice invoice = keeper.issuance(request, policy);

        assertThat(invoice.getItems().size(), is(1));
        assertThat(invoice.getItems().get(0).getTax().getAmount(), equalTo(policy.calculateTax(ProductType.STANDARD, item.getTotalCost()).getAmount()));
        assertThat(invoice.getItems().get(0).getTax().getDescription(), equalTo(policy.calculateTax(ProductType.STANDARD, item.getTotalCost()).getDescription()));
    }
}