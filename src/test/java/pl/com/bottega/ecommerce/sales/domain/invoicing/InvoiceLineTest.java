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
public class InvoiceLineTest {
    @Test
    public void getProduct() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        Tax tax = new Tax(new Money(12.4), "Vat");
        InvoiceLine invoiceLine = new InvoiceLine(product, 1 , new Money(12.4), tax);

        assertThat(invoiceLine.getProduct(), is(product));
    }

    @Test
    public void getQuantity() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        Tax tax = new Tax(new Money(12.4), "Vat");
        InvoiceLine invoiceLine = new InvoiceLine(product, 1 , new Money(12.4), tax);

        assertThat(invoiceLine.getQuantity(), is(1));
    }

    @Test
    public void getNet() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        Tax tax = new Tax(new Money(12.4), "Vat");
        InvoiceLine invoiceLine = new InvoiceLine(product, 1 , new Money(12.4), tax);

        assertThat(invoiceLine.getNet(), is(new Money(12.4)));
    }

    @Test
    public void getGros() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        Tax tax = new Tax(new Money(12.4), "Vat");
        InvoiceLine invoiceLine = new InvoiceLine(product, 1 , new Money(12.4), tax);

        assertThat(invoiceLine.getGros(), is(new Money(24.8)));
    }

    @Test
    public void getTax() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        Tax tax = new Tax(new Money(12.4), "Vat");
        InvoiceLine invoiceLine = new InvoiceLine(product, 1 , new Money(12.4), tax);

        assertThat(invoiceLine.getTax(), is(tax));
    }

}