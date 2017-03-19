package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Patryk Wierzyński
 */

public class InvoiceFactoryTest {

	@Test
	public void createInvoiceHasExpectedType() {
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		ClientData clientData = new ClientData(Id.generate(), "Test");
		Object object = invoiceFactory.create(clientData);
		assertThat(object, is(instanceOf(Invoice.class)));
	}

}