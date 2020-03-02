package com.example.demo.mapper;

import com.example.demo.dto.request.DepartmentRequest;
import com.example.demo.dto.response.DepartmentResponse;
import com.example.demo.model.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(source = "changeDate", dateFormat = "dd/MM/yyyy hh:mm:ss", target = "changeDate")
    DepartmentResponse departmentEntityToDepartmentResponse(DepartmentEntity departmentEntity);

    DepartmentEntity departmentRequestToDepartmentEntity(DepartmentRequest departmentRequest);

}
