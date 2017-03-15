package pl.com.bottega.ecommerce.sales.domain.purchase;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 15.03.2017.
 */
public class PurchaseItemTest {
    @Test
    public void getQuantity() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        PurchaseItem purchaseItem = new PurchaseItem(product,2, new Money(24.8));

        assertThat(purchaseItem.getQuantity(), is(2));
    }

    @Test
    public void getProductData() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        PurchaseItem purchaseItem = new PurchaseItem(product,2, new Money(24.8));

        assertThat(purchaseItem.getProductData(), is(product));
    }

    @Test
    public void getTotalCost() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        PurchaseItem purchaseItem = new PurchaseItem(product,2, new Money(24.8));

        assertThat(purchaseItem.getTotalCost(), is(new Money(24.8)));
    }

}