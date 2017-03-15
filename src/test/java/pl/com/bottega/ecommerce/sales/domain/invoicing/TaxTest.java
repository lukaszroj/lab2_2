package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 16.03.2017.
 */
public class TaxTest {
    @Test
    public void getAmount() throws Exception {
        Tax tax = new Tax(new Money(12.4), "Vat");

        assertThat(tax.getAmount(), is(new Money(12.4)));
    }

    @Test
    public void getDescription() throws Exception {
        Tax tax = new Tax(new Money(12.4), "Vat");

        assertThat(tax.getDescription(), is("Vat"));
    }

}