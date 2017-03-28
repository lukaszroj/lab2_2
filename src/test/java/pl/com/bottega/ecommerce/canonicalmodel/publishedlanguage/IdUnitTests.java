package pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.*;


import org.junit.Test;


public class IdUnitTests {

	@Test
	public void generateTest() throws Exception{
		Id id = new Id(Id.generate().toString());
		assertThat(id, is(notNullValue()));
	}
	
	@Test
	public void hashCodeTestAreIdsAreDifferent() throws Exception{
		Id testId1 = new Id("1");
		Id testId2 = new Id("2");
		
		assertThat(testId1.equals(testId2), is(false));
	}
	
	@Test
	public void hashCodeTestAreIdsAreTheSame() throws Exception{
		Id testId1 = new Id("1");
		Id testId2 = new Id("1");
		
		assertThat(testId1.equals(testId2), is(true));
	}
}
