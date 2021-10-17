package edu.kea.adventure_project.services;

import edu.kea.adventure_project.models.Product;
import edu.kea.adventure_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Julius Panduro
 */
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public void createProduct(Product product) {
        productRepository.save(product);

    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product readProductById(Long id){
        return productRepository.getById(id);
    }

    //Frederik
    public void updateProduct(Long productID, Product product){
        productRepository.findById(productID);
        productRepository.save(product);
    }

    public void deleteProduct(Long productID){
        productRepository.deleteById(productID);
    }


}
