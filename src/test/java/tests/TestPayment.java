/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 *
 * @author jankowskirobert
 */
public class TestPayment {
    
    @Test(expected = NullPointerException.class)
    public void testPaymentRollback(){
        PaymentFactory factory = new PaymentFactory();
        ClientData data = new ClientData(Id.generate(), "Tester");
        Money money = new Money(100);
        Payment payment = factory.createPayment(data, money);
        Payment paymentRollback = payment.rollBack();        
    }
}
