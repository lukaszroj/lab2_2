package pl.lab2_2.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;

public class InvoiceFactoryTest {

	@Test
	public void createInvoiceHasExpectedType() {
		
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		ClientData clientData = new ClientData(Id.generate(), "testowa");
		Object object = invoiceFactory.create(clientData);
		assertThat(object, is(instanceOf(Invoice.class)));
	}

}
