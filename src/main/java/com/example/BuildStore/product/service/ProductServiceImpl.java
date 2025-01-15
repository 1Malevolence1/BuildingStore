package com.example.product.service;

import com.example.product.convert.ProductManagerMapper;
import com.example.product.dto.ProductCreateRequestDto;
import com.example.product.dto.ProductResponseDto;
import com.example.product.dto.ProductUpdateRequestDto;
import com.example.product.model.Product;
import com.example.product.model.ProductType;
import com.example.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductManagerMapper productManagerMapper;


    @Override
    public void create(ProductCreateRequestDto dto) {
            Product model = productManagerMapper.toModel(dto);
            model.setProductType(new ProductType(dto.productTypeId(), null ,null, null));
            productRepository.save(model);
    }

    @Override
    public ProductResponseDto findProduct(Long productId) {
        Product product = productRepository.findById(
                        productId
                )
                .orElseThrow(
                        () -> new NoSuchElementException("Not found product with ID::%d".formatted(productId))
                );

        log.info("{}", product.getProductType());
        return productManagerMapper.toDto(product);

    }

    @Override
    public Product getEntityProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Not found product with ID::%d".formatted(productId)));
    }

    @Override
    public List<ProductResponseDto> findAllProduct() {
        return productManagerMapper.toListDto(
                productRepository.findAll()
        );
    }

    @Override
    public void deleteProductBuId(Long prodcutId) {
        productRepository.deleteById(prodcutId);
    }

    @Override
    @Transactional
    public void updateProduct(ProductUpdateRequestDto dto) {
        Product model = productManagerMapper.toModel(dto);
        model.setProductType(new ProductType(dto.productTypeId(), null ,null, null));
        productRepository.save(model);
    }
}
