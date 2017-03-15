package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 16.03.2017.
 */
public class InvoiceTest {
    @Test
    public void addItem() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(10),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        Tax tax = new Tax(new Money(6.4), "Vat");
        InvoiceLine invoiceLine = new InvoiceLine(product, 1 , new Money(9.2), tax);
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Invoice invoice = new Invoice(new Id("01"), clientData);

        invoice.addItem(invoiceLine);

        assertThat(invoice.getItems(), is(notNullValue()));
    }

    @Test
    public void getClient() throws Exception {
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Invoice invoice = new Invoice(new Id("01"), clientData);

        assertThat(invoice.getClient(), is(clientData));
    }

    @Test
    public void getNet() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(10),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        Tax tax = new Tax(new Money(6.4), "Vat");
        InvoiceLine invoiceLine = new InvoiceLine(product, 1 , new Money(9.2), tax);
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Invoice invoice = new Invoice(new Id("01"), clientData);

        invoice.addItem(invoiceLine);

        assertThat(invoice.getNet(), is(new Money(9.2)));
    }

    @Test
    public void getGros() throws Exception {
        ProductData product = new ProductData(new Id("0"),new Money(12.4),"Hamburger", ProductType.FOOD, new Date(2017,3,15));
        Tax tax = new Tax(new Money(6.4), "Vat");
        InvoiceLine invoiceLine = new InvoiceLine(product, 1 , new Money(9.2), tax);
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Invoice invoice = new Invoice(new Id("01"), clientData);

        invoice.addItem(invoiceLine);

        assertThat(invoice.getGros(), is(new Money(15.6)));
    }

}