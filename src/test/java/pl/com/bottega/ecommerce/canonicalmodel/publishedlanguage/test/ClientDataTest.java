package pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class ClientDataTest {

	@Test
	public void testGetName() {
		Id id = new Id();
		ClientData clientData = new ClientData(id, "Richard");
		assertEquals("Richard", clientData.getName());
	}

}
