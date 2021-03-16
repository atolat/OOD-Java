package com.ood.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User{
    List<Product> products;
    public Seller(String name, String phone) {
        super(name, phone);
        products = new ArrayList<>();

    }

    public void registerProduct(Product product, ProductCatalog catalog) {
        product.setSeller(this);
        catalog.addProduct(product);
        products.add(product);
    }

    public void updateProductQuantity(Product product, ProductCatalog catalog, int quantity) {
        catalog.updateProductQuantity(product, quantity);
    }

    public void removeProduct(Product product, ProductCatalog catalog) {
        catalog.removeProduct(product);
        products.remove(product);
    }

    @Override
    public String toString() {
        return "Seller{}"+ super.toString();
    }
}
