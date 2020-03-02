package com.example.demo.mapper;

import com.example.demo.dto.request.ProductRequest;
import com.example.demo.exception.BusinessServiceException;
import com.example.demo.model.DepartmentEntity;
import com.example.demo.model.ProductEntity;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

public abstract class ProductMapperDecorator implements ProductMapper {

    @Autowired
    @Qualifier("delegate")
    private ProductMapper delegate;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public ProductEntity productRequestToProductEntity(Long departmentId, ProductRequest productRequest) {
        ProductEntity product = delegate.productRequestToProductEntity(departmentId, productRequest);
        product.setDepartment(getDepartment(departmentId));
        return product;
    }

    private DepartmentEntity getDepartment(Long departmentId) {
        Optional<DepartmentEntity> optional = departmentRepository.findById(departmentId);
        if (optional.isPresent())
            return optional.get();
        throw new BusinessServiceException("Departamento invalido");
    }

}
