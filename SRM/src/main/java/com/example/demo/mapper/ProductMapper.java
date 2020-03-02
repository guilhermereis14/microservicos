package com.example.demo.mapper;

import com.example.demo.dto.request.ProductRequest;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.model.ProductEntity;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
@DecoratedWith(ProductMapperDecorator.class)
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "department.name", target = "department"),
            @Mapping(source = "changeDate", dateFormat = "dd/MM/yyyy hh:mm:ss", target = "changeDate")
    })
    ProductResponse productEntityToProductResponse(ProductEntity productEntity);

    ProductEntity productRequestToProductEntity(Long departmentId, ProductRequest productRequest);

}
