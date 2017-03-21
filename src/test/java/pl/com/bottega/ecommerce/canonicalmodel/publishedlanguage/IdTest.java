package pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;
import org.junit.Test;

public class IdTest {

	@Test
	public void testGeneratedId() {
		Id id1 = Id.generate();
		Id id2 = Id.generate();
		
		Assert.assertThat(id1, is(not(equalTo(id2))));
	}

}
