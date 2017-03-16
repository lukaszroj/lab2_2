package pl.com.bottega.ecommerce.sales.domain.productscatalog;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

public class ProductDataTestFactory {

    public static ProductData create(Money money, String name, ProductType type) {
        return new ProductData(Id.generate(), money, name, type, new Date());
    }
}