package com.example.springmapstructdemp.controller;

import com.example.springmapstructdemp.dto.ProductDto;
import com.example.springmapstructdemp.mapper.ProductMapper;
import com.example.springmapstructdemp.model.Product;
import com.example.springmapstructdemp.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    public ProductController(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productRepository.save(
                productMapper.dtoToModel(productDto)), HttpStatus.CREATED);

    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAll() {
        return new ResponseEntity<>(productMapper.modelToDtos(productRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(productMapper.modelToDto(productRepository.findById(id).get()), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Integer id) {
        ProductDto productDto = productMapper.modelToDto(productRepository.findById(id).get());

        productRepository.deleteById(productDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
