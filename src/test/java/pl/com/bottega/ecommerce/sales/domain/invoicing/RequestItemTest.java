package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 16.03.2017.
 */
public class RequestItemTest {
    @Test
    public void getTotalCost() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        RequestItem requestItem = new RequestItem(product, 2, new Money(24.8));

        assertThat(requestItem.getTotalCost(), is(new Money(24.8)));
    }

    @Test
    public void getProductData() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        RequestItem requestItem = new RequestItem(product, 2, new Money(24.8));

        assertThat(requestItem.getProductData(), is(product));
    }

    @Test
    public void getQuantity() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        RequestItem requestItem = new RequestItem(product, 2, new Money(24.8));

        assertThat(requestItem.getQuantity(), is(2));
    }

}