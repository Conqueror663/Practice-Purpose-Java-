package com.Practice.Web.service;
import com.Practice.Web.model.Product;
import com.Practice.Web.repositary.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductService {


    @Autowired
    ProductRepo repo;

    public Product getProductId(int prodId){
        return repo.findById(prodId).orElse(null);
    }

    public void addProduct( Product product){
        repo.save(product);
    }

    public void updateProduct(Product product) {
     repo.save(product);
    }
    public void deleteProduct(Product product) {
    repo.delete(product);
    }


    public List<Product> getProduct() {
        return repo.findAll();
    }
}
