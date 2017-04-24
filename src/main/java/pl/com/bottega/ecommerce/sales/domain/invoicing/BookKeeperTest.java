package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Krzysztof Zimny on 4/25/2017.
 */
public class BookKeeperTest {

    private ClientData clientData;
    private BookKeeper bookKeeper;
    private TaxPolicy taxPolicy;

    @Before
    public void setUp() throws Exception {
        clientData = createClientDataInstance();
        bookKeeper = createBookKeeperInstance();
        taxPolicy = createTaxPolicyMockInstance();
    }

    private BookKeeper createBookKeeperInstance() {
        return new BookKeeper();
    }

    private TaxPolicy createTaxPolicyMockInstance() {
        return new TaxPolicy() {
            public Tax calculateTax(ProductType productType, Money net) {
                return new Tax(new Money(0.1), "mock");
            }
        };
    }

    @Test
    public void createIssuanceAndCheckPriceAfterTaxTest() {
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
        ProductData productData = new ProductData(Id.generate(), new Money(50),
                "box", ProductType.STANDARD, new Date());
        RequestItem requestItem = new RequestItem(productData, 1, productData.getPrice());
        invoiceRequest.add(requestItem);
        InvoiceLine expectedResult = new InvoiceLine(productData, 1, new Money(50),
                taxPolicy.calculateTax(productData.getType(), requestItem.getTotalCost()));
        InvoiceLine result = bookKeeper.issuance(invoiceRequest, taxPolicy).getItems().get(0);
        assertThat(result.getGros(), equalTo(expectedResult.getGros()));
    }

    private ClientData createClientDataInstance() {
        return new ClientData(Id.generate(), "Krzysztof Zimny");
    }
}
