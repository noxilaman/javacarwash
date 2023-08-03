package com.noxil.carwash.mapper;

import com.noxil.carwash.entity.Product;
import com.noxil.carwash.model.MProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    MProductResponse toProductResponse(Product product);
}
