package controller;

import model.Product;

public interface ProductControllerIF {

    Product findByBarcode(String barcode);

    void updateProduct(Product product);

    void insertProduct(Product product);
}