package com.codearti.service;

import com.codearti.model.dto.ProductCreateRequestDto;
import com.codearti.model.dto.ProductResponseDto;
import com.codearti.model.dto.ProductUpdateRequestDto;
import com.codearti.model.dto.ProductUpdateStockRequestDto;
import com.codearti.model.entity.ProductStatus;

import java.util.List;

public interface IProductService {
    List<ProductResponseDto> findAll(ProductStatus status, int port);

    ProductResponseDto findById(Long id, int port);

    List<ProductResponseDto> findByIdCategory(Long id, int port);

    ProductResponseDto create(ProductCreateRequestDto productRequest, int port);

    ProductResponseDto update(Long id, ProductUpdateRequestDto productRequest, int port);

    ProductResponseDto updateStock(Long id, ProductUpdateStockRequestDto productRequest, int port);

    void delete(Long id, int port);
}
