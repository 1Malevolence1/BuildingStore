package com.example.saleDetails.service;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import com.example.sale.model.Sale;
import com.example.sale.service.SaleService;
import com.example.saleDetails.dto.SaleDetailCreateRequestDto;
import com.example.saleDetails.dto.SaleDetailResponseDto;
import com.example.saleDetails.dto.SaleDetailUpdateRequestDto;
import com.example.saleDetails.mapper.SaleDetailManagerMapper;
import com.example.saleDetails.model.SaleDetail;
import com.example.saleDetails.repository.SaleDetailRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SaleDetailServiceImpl implements SaleDetailService {

    private final SaleDetailRepository saleDetailRepository;
    private final SaleDetailManagerMapper saleDetailManagerMapper;
    private final SaleService saleService;
    private final ProductService productService;

    @Override
    public void create(SaleDetailCreateRequestDto dto) {
      saleService.getEntitySale(dto.saleId());
      productService.getEntityProduct(dto.productId());
       saleDetailRepository.save(
               saleDetailManagerMapper.toModel(dto)
       );
    }

    @Override
    public void update(SaleDetailUpdateRequestDto dto) {
      Sale sale =   saleService.getEntitySale(dto.saleId());
      Product product =  productService.getEntityProduct(dto.productId());

        saleDetailRepository.findById(dto.id()).ifPresentOrElse(
                saleDetail -> {
                    saleDetail.setPrice(dto.price());
                    saleDetail.setQuantity(dto.quantity());
                    saleDetail.setProduct(product);
                    saleDetail.setSale(sale);
                }, () -> {
                    throw new NoSuchElementException("Not found saleDetail with ID::%d".formatted(dto.id()));
                }
        );
    }

    @Override
    public SaleDetailResponseDto get(Long id) {
        return saleDetailManagerMapper.toDto(saleDetailRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found saleDetail with ID::%d".formatted(id))));
    }

    @Override
    public List<SaleDetailResponseDto> getAll() {
        return saleDetailManagerMapper.toListDto(
                saleDetailRepository.findAll()
        );
    }

    @Override
    public void delete(Long id) {
        saleDetailRepository.deleteById(id);
    }
}
