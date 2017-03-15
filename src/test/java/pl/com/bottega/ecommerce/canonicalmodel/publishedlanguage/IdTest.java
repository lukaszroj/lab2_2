package pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 15.03.2017.
 */
public class IdTest {
    @Test
    public void generate() throws Exception {
        Id id = new Id(Id.generate().toString());
        assertThat(id, is(notNullValue()));
    }

    @Test
    public void getId() throws Exception {
        Id id = new Id("01");
        assertThat(id.getId(), is("01"));
    }

    @Test
    public void equals() throws Exception {

    }

}