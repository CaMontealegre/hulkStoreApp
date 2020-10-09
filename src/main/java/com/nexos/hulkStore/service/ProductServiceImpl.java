/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexos.hulkStore.service;

import com.nexos.hulkStore.domain.Product;
import com.nexos.hulkStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Montealegre
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getAllProductById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product createProduct(Product user) {
        return productRepository.save(user);
    }

    @Override
    public Product editProduct(Product user) {

        Product userFind = getAllProductById(user.getId());
        validateEditProduct(user, userFind);
        return productRepository.save(userFind);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    protected void validateEditProduct(Product initial, Product end) {
        end.setDescription(initial.getDescription());
        end.setBrand(initial.getDescription());
        end.setPrice(initial.getDescription());
        end.setQuantity(initial.getDescription());
    }
}
