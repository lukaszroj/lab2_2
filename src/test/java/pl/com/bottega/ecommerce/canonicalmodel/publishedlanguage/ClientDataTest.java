package pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 16.03.2017.
 */
public class ClientDataTest {
    @Test
    public void getAggregateId() throws Exception {
        ClientData clientData = new ClientData(new Id("02"), "Adam");

        assertThat(clientData.getAggregateId(), is(new Id("02")));
    }

    @Test
    public void getName() throws Exception {
        ClientData clientData = new ClientData(new Id("02"), "Adam");

        assertThat(clientData.getName(), is("Adam"));
    }

}