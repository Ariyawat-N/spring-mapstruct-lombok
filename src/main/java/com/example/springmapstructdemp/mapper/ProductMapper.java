package com.example.springmapstructdemp.mapper;


import com.example.springmapstructdemp.dto.ProductDto;
import com.example.springmapstructdemp.model.Product;
import com.example.springmapstructdemp.validate.ProductValidationException;
import com.example.springmapstructdemp.validate.ProductValidator;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(uses = {ProductValidator.class},
        componentModel = "spring", imports = UUID.class)
public interface ProductMapper {

//    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto modelToDto(Product product) throws ProductValidationException;

    List<ProductDto> modelToDtos(List<Product> product) throws ProductValidationException;


    //    @Mapping(source = "productDto.description",target = "desc", defaultValue = "description")
    @InheritConfiguration
    Product dtoToModel(ProductDto productDto) throws ProductValidationException;
}
