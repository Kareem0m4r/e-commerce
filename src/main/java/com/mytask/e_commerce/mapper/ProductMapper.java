package com.mytask.e_commerce.mapper;

import com.mytask.e_commerce.dto.ProductDTO;
import com.mytask.e_commerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

   // @Mapping(source = "shoppingCartId", target = "")
    Product toEntity(ProductDTO productDTO);

    ProductDTO toDTO(Product product);

    List<ProductDTO> toDTOList(List<Product> productList);
}
