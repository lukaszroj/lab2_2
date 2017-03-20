package pl.com.bottega.ecommerce.sales.domain.invoicing.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;

public class InvoiceFactoryTest {

	@Test
 	public void testCreate() {
 		InvoiceFactory invoiceFactory = new InvoiceFactory();
 		ClientData clientData = new ClientData(Id.generate(), "Test");
 		Invoice invoice = invoiceFactory.create(clientData);
 		assertThat(invoice, notNullValue());
 	}
}