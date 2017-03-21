package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class InvoiceFactoryTest {

    @Test
    public void shouldCreateInvoiceInstance() throws Exception {
        //given:
        final InvoiceFactory invoiceFactory = new InvoiceFactory();
        final ClientData ANY_CLIENT_DATA = new ClientData(Id.generate(), "anyName");


        //when:
        Object object = invoiceFactory.create(ANY_CLIENT_DATA);

        //then:
        assertThat(object,instanceOf(Invoice.class));
    }
}