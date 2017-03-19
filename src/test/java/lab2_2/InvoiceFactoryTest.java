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
	public void testCreate() {
		
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		ClientData clientData = new ClientData(new Id("194972"), "Aleksander Kaczmarczyk");
		
		Invoice invoice = invoiceFactory.create(clientData);
		Assert.assertThat(invoice, notNullValue());
		Assert.assertThat(invoice, is(instanceOf(Invoice.class)));
	}

}
