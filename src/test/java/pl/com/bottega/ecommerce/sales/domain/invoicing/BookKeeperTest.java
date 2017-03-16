package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.junit.Assert.*;

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
    public void issuance() throws Exception {

    }

}