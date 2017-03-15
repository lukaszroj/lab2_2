package pl.com.bottega.ecommerce.sales.domain.purchase;


import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 15.03.2017.
 */
public class PurchaseTest {
    @Test
    public void confirm() throws Exception {
        List<PurchaseItem> items = null;
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Money money = new Money(12.4);
        Purchase purchase = new Purchase(new Id("01"), clientData, items, new Date(2017,03,15),false, money);

        purchase.confirm();

        assertThat(purchase.isPaid(), is(true));
    }

    @Test
    public void isPaid() throws Exception {
        List<PurchaseItem> items = null;
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Money money = new Money(12.4);
        Purchase purchase = new Purchase(new Id("01"), clientData, items, new Date(2017,03,15),false, money);

        assertThat(purchase.isPaid(), is(false));
    }

    @Test
    public void getTotalCost() throws Exception {
        List<PurchaseItem> items = null;
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Money money = new Money(12.4);
        Purchase purchase = new Purchase(new Id("01"), clientData, items, new Date(2017,03,15),false, money);

        assertThat(purchase.getTotalCost(), is(money));
    }

    @Test
    public void getPurchaseDate() throws Exception {
        List<PurchaseItem> items = null;
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Money money = new Money(12.4);
        Purchase purchase = new Purchase(new Id("01"), clientData, items, new Date(2017,03,15),false, money);

        assertThat(purchase.getPurchaseDate(), is(new Date(2017,03,15)));
    }

    @Test
    public void getClientData() throws Exception {
        List<PurchaseItem> items = null;
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Money money = new Money(12.4);
        Purchase purchase = new Purchase(new Id("01"), clientData, items, new Date(2017,03,15),false, money);

        assertThat(purchase.getClientData(), is(clientData));
    }

    @Test
    public void getAggregateId() throws Exception {
        List<PurchaseItem> items = null;
        ClientData clientData = new ClientData(new Id("02"), "Adam");
        Money money = new Money(12.4);
        Purchase purchase = new Purchase(new Id("01"), clientData, items, new Date(2017,03,15),false, money);

        assertThat(purchase.getAggregateId(), is(new Id("01")));
    }

}