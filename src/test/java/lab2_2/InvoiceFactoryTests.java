package lab2_2;
import org.junit.Assert;
import org.junit.Test;


import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;

public class InvoiceFactoryTests {

	@Test
	public void tests() {
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		Invoice invoice = invoiceFactory.create(new ClientData(Id.generate(), "Piotr Treliñski"));
		Assert.assertThat(invoice, is(instanceOf(Invoice.class)));		
	}

}
