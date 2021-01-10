package pl.edu.wszib.magazyn.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.magazyn.dao.IProductDAO;
import pl.edu.wszib.magazyn.model.Product;
import pl.edu.wszib.magazyn.services.IProductService;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDAO productDAO;

    @Override
    public Product getProductById(int id) {
        return this.productDAO.getProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        Product  DBProduct = this.productDAO.getProductById(product.getId());
        DBProduct.setId(product.getId());
        DBProduct.setName(product.getName());
        DBProduct.setPieces(product.getPieces());
        DBProduct.setPrice(product.getPrice());
        this.productDAO.updateProduct(DBProduct);
    }

    @Override
    public void deleteProduct(int id){
        this.productDAO.deleteProduct(id);
    }

    @Override
    public void addProduct(Product product){
        this.productDAO.addProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productDAO.getAllProducts();
    }
}
