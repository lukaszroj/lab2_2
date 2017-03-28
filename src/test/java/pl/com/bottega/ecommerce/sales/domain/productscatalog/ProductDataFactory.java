package pl.com.bottega.ecommerce.sales.domain.productscatalog;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

/**
 * Created by Wojciech Szczepaniak on 19.03.2017.
 */
public class ProductDataFactory {

    public ProductData createProductData(Money price, String name, ProductType type) {
        return new ProductData(Id.generate(), price, name, type, new Date());
    }
}
