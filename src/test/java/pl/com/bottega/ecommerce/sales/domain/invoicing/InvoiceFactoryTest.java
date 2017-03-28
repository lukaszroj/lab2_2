package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class InvoiceFactoryTest {
	
	@Test
	public void testInvoiceFactory() {
		ClientData client = new ClientData(Id.generate(), "Test");
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		Assert.assertThat(invoiceFactory.create(client), instanceOf(Invoice.class));
	}

}
