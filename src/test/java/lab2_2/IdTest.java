package lab2_2;

import static org.hamcrest.CoreMatchers.*;


import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class IdTest {

	@Test
	public void testGenerate() {
		
		Id firstId = Id.generate();
		Id secondId = Id.generate();
		
		Assert.assertThat(firstId, is(not(secondId)));
	}
	
}
