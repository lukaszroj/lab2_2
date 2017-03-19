package pl.com.bottega.ecommerce.sales.domain.invoicing;

import static org.junit.Assert.*;

/**
 * Created by Sasho on 2017-03-19.
 */
public class BookKeeperTest {

    //Jedyna metoda w klasie BookKeepper (issuance) jest nietestowalna ze względu na brak publicznego konstruktora klasy
    //ProductData (niezbędnej do wygenerowania sensownych parametrów) oraz niezainicjalizowane nigdzie InvoiceFactory
    // (w klasie BookKeeper)
}