package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Collection;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 16.03.2017.
 */
public class InvoiceRequestTest {
    @Test
    public void add() throws Exception {
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        RequestItem requestItem = new RequestItem(product, 2, new Money(24.8));

        invoiceRequest.add(requestItem);

        assertThat(invoiceRequest.getItems(), is(notNullValue()));
    }

}