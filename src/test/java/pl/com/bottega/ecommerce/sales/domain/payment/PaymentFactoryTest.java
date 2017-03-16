package pl.com.bottega.ecommerce.sales.domain.payment;

import org.junit.Before;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.junit.Assert.*;

public class PaymentFactoryTest {

    private ClientData clientData;

    @Before
    public void setUp() throws Exception {
        clientData = new ClientData(Id.generate(), "John Doe");
    }

}