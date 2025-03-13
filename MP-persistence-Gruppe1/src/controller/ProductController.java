package controller;

import db.ProductDB;
import db.ProductDBIF;
import model.Product;

public class ProductController implements ProductControllerIF {

    ProductDBIF productDB;

    ProductController() {
        productDB = new ProductDB();
    }

    @Override
    public Product findProductByBarcode(String barcode) {
        return productDB.findProductByBarcode(barcode);
    }

    @Override
    public void updateProduct(Product product) {
        productDB.updateProduct(product);
    }

    @Override
    public void insertProduct(Product product) {
        productDB.insertProduct(product);
    }

}