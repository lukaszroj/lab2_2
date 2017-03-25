package pl.com.bottega.ecommerce.sales.domain.invoicing;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import org.junit.Test;

public class InvoiceFactoryUnitTests {

		@Test
		public void createInvoiceHaveExpectedType() {
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		ClientData clientData = new ClientData(Id.generate(), "Test");
		Object result = invoiceFactory.create(clientData);
		
		assertThat(result, is(instanceOf(Invoice.class)));
	}
}
