package com.example.ecom_project.controller;

import com.example.ecom_project.model.product;
import com.example.ecom_project.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class productController {

    @Autowired
    private productService service; // now we have made the reference og productService class, with @Autowired the obj can be made by spring boot

    @GetMapping("/products")
    public ResponseEntity<List<product>> getAllProducts() { // we r using response entity to return the status code along
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK); // controller will go to service layer
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<product> getproduct(@PathVariable int id) { // controller will go to service layer

        product product = service.getProductById(id); // doing this to check if the product is there
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(
            @RequestPart product product,
            @RequestPart MultipartFile imageFile) {

        try {
            System.out.println(product);
            product saved = service.addProduct(product,imageFile);
            return new ResponseEntity<>(saved,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable("productId") int productId){

        product product = service.getProductById(productId);
        byte[] imageFile = product.getImageData();

        return ResponseEntity.ok().
                contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,  @RequestPart product product,
                                                @RequestPart MultipartFile imageFile){
        product product1 = null;
        try {
            product1 = service.updateProduct(id, product, imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (product1 != null){
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        product product = service.getProductById(id);
        if (product != null) {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<product>> searchProduct(@RequestParam String keyword){
        System.out.println("Searching with " + keyword);
        List<product> productList = service.searchProduct(keyword);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
