/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Date;
import static org.hamcrest.core.Is.is;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceLine;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 *
 * @author jankowskirobert
 */
public class TestInvoice {
    
    @Test
    public void testDefaultObjectParameters(){
        Id defaultID = Id.generate();
        ClientData clientData = new ClientData(defaultID, "Tester");
        InvoiceFactory factory = new InvoiceFactory();
        Invoice invoice = factory.create(clientData);
        assertThat(invoice.getGros(), is(Money.ZERO));
        assertThat(invoice.getNet(), is(Money.ZERO));   
        assertThat(invoice.getClient().equals(clientData), is(true));
        assertThat(invoice.getItems().size(), is(0));
    }
        
}
