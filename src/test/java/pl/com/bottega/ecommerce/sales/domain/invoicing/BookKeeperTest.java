package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class BookKeeperTest {

    private BookKeeper keeper;
    private TaxPolicy policy;
    private ClientData clientData;

    private class MockTaxPolicy implements TaxPolicy {

        public Tax calculateTax(ProductType productType, Money net) {
            return new Tax(net.multiplyBy(0.2), "MockTax");
        }
    }

    //class BookKeeper currently untestable due to lack of possibility to inject invoiceFactory to BookKeeper
    /*
        class currently untestable due to lack of possibility to create ProductData required for creating
        RequestItem which is necessary for creating InvoiceRequest with any meaningful data, witch is necessary for tests
    */

    @Before
    public void setUp() throws Exception {
        keeper = new BookKeeper();
        policy = new MockTaxPolicy();
        clientData = new ClientData(Id.generate(), "John Doe");
    }
}