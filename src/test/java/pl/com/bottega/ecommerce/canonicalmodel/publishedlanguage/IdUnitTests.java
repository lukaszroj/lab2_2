package pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.*;


import org.junit.Test;


public class IdUnitTests {

	@Test
	public void generate() throws Exception{
		Id id = new Id(Id.generate().toString());
		assertThat(id, is(notNullValue()));
	}
}
