package lab2_2;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;

public class TInvoiceFactory {

	@Test
	public void invoiceFactoryCreatesCorrectInstance() {
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		Invoice invoice = invoiceFactory.create(new ClientData(Id.generate(), "Orasu"));

		Assert.assertThat(invoice, Matchers.is(Matchers.instanceOf(Invoice.class)));
	}

}
