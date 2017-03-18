package lab2_2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;

public class InvoiceFacoryTest {

	@Test
	public void testCreateInvoice() {
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		Invoice invoice = invoiceFactory.create(new ClientData(Id.generate(),"Milosz"));
		
		assertThat(invoice, is(instanceOf(Invoice.class)));
	}

}
