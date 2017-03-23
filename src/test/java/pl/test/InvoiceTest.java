package pl.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;

public class InvoiceTest {

	@Test
	public void invoiceExistsTest() {
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		Invoice invoice = invoiceFactory.create(new ClientData(new Id("id"), "clientData"));

		assertThat(invoice, is(not(nullValue())));
	}

}
