package com.example.ecom_project.service;

import com.example.ecom_project.model.product;
import com.example.ecom_project.repository.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class productService {

    @Autowired
    private productRepo repo; // the service layer will connect with repository layer

    public List<product> getAllProducts() {
       return repo.findAll(); // this will give list of product
    }

    public product getProductById(int id) {
        return repo.findById(id).orElse(new product()); // service layer will ask repo to do the job
    }

    public product addProduct(product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public product updateProduct(int id, product product,MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getContentType());
        product.setImageType(imageFile.getContentType());
       return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<product> searchProduct(String keyword) {
        return repo.searchProduct(keyword);
    }
}
