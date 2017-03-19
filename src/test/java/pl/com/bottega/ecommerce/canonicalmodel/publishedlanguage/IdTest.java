package pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Patryk Wierzynski
 */

public class IdTest {

	@Test
	public void equalsIsEqual() {
		Id first = new Id("test");
		Id second = new Id("test");
		assertThat(first.equals(second), is(true));
	}

	@Test
	public void equalsIsNotEqual() {
		Id first = new Id("test");
		Id second = new Id("testx");
		assertThat(first.equals(second), is(false));
	}

}