package controller;

import model.Product;

public interface ProductControllerIF {

    Product findProductByBarcode(String barcode);

    void updateProduct(Product product);

    void insertProduct(Product product);
}