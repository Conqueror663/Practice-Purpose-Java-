package com.Practice.Web.controller;

import com.Practice.Web.model.Product;
import com.Practice.Web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
//@CrossOrigin//for connecting different port like front end and back-end
public class ProductController {

    @Autowired
    ProductService service ;

    @GetMapping
    public List<Product> getProduct(){
        return service.getProduct();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable int productId) {


        List<Product> products = service.getProduct();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getProductId() == productId){
                return products.get(i);
            }

        }
        return null;//new Product(100,"No Item");
    }

    @PostMapping
    public void addProduct (@RequestBody Product product){
        service.addProduct(product);
    }

    @PutMapping
    public void update(@RequestBody Product product){
        service.updateProduct(product);
    }

    @DeleteMapping
    public void delete(@RequestBody Product product){
        service.deleteProduct(product);
    }


}
