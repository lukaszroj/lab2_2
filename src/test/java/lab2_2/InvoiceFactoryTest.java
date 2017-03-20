package lab2_2;

import static org.hamcrest.CoreMatchers.*;


import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;


public class InvoiceFactoryTest {

	@Test
	public void testCreateInvoice() {
		
		InvoiceFactory factory = new InvoiceFactory();
		Invoice invoice = factory.create(new ClientData(Id.generate(), "John Doe"));
		
		Assert.assertThat(invoice, instanceOf(Invoice.class));
	}
}
