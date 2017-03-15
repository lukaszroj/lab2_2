package pl.com.bottega.ecommerce.sales.domain.productscatalog;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import static org.hamcrest.CoreMatchers.is;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 15.03.2017.
 */
public class ProductDataTest {

    @Test
    public void getProductId() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        assertThat(product.getProductId(), is(new Id("0")));
    }

    @Test
    public void getPrice() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        assertThat(product.getPrice(), is(new Money(12.4)));
    }

    @Test
    public void getName() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        assertThat(product.getName(), is("Hamburger"));
    }

    @Test
    public void getSnapshotDate() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        assertThat(product.getSnapshotDate(), is(new Date(2017,3,15)));
    }

    @Test
    public void getType() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        assertThat(product.getType(), is(ProductType.FOOD));
    }

    @Test
    public void equals() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        ProductData theSameProduct = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        assertThat(product.equals(theSameProduct), is(true));
    }

}