package pl.com.bottega.ecommerce.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Before;

import pl.com.bottega.ecommerce.sales.domain.invoicing.*;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.*;

public class InvoiceFactoryTest {
	
	private Id clientId;
	private String clientName;
	
	@Before
	public void initialize() {
		clientId = Id.generate();
		clientName = "Name";
	}
		
	@Test
	public void createTest() {
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		assertThat(invoiceFactory.create(new ClientData(clientId, clientName)), instanceOf(Invoice.class));
	}
}
