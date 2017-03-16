package lab2_2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;

public class InvoiceFactoryTest {

	@Test
	public void checkIfCorrectReturnTypeFromFactory() {
		InvoiceFactory ifact = new InvoiceFactory();
		Invoice reality = ifact.create(new ClientData(Id.generate(), "Mateusz"));
		assertThat(reality, is(instanceOf(Invoice.class)));
	}
}
