package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.exceptions.ProductException;
import com.app.model.Product;
import com.app.service.ProductService;

public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("/getallproducts")
    public ResponseEntity<List<Product>> getAllProductsHandler() throws ProductException{
    	
    	List<Product> allProducts = productService.viewAllProducts();
    	
    	return new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);
    	
    }
    
    @PostMapping("/addproducts")
    public ResponseEntity<Product> addProductHandler(@RequestBody Product product ) throws ProductException{
    	
    	Product addedProduct = productService.addProduct(product);
    	
    	return new ResponseEntity<Product>(addedProduct, HttpStatus.CREATED);
    	
    }
    
    @PutMapping("/updateproduct")
    public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) throws ProductException{
    	
    	Product updatedProduct = productService.updateProduct(product);
    	
    	return new ResponseEntity<Product>(updatedProduct, HttpStatus.ACCEPTED);
    	
    }
    
    @GetMapping("/getproduct/{productId}")
    public ResponseEntity<Product> getProductHandler(@PathVariable("productId") Integer productId) throws ProductException{
    	
    	Product exixtingProduct = productService.viewProduct(productId);
    	
    	return new ResponseEntity<Product>(exixtingProduct, HttpStatus.OK);
    	
    }
    
    @GetMapping("/getproductbycname/{categoryName}")
    public ResponseEntity<List<Product>> getProductByCategoryHandler(@PathVariable("categoryName") String categoryName) throws ProductException{
    	
    	List<Product> categorywiseProducts = productService.viewProductByCategory(categoryName);
    	
    	return new ResponseEntity<List<Product>>(categorywiseProducts, HttpStatus.OK);
    	
    }
    
    
    @DeleteMapping("/deleteproduct/{productId}")
    public ResponseEntity<Product> deleteProductHandler(@PathVariable("productId") Integer productId) throws ProductException{
    	
    	Product deletedProduct = productService.removeProduct(productId);
    	
    	return new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);
    	
    }
}
