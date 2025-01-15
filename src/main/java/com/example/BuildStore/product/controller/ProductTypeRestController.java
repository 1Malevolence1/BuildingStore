package com.example.product.controller;


import com.example.product.dto.ProductTypeCreateRequestDto;
import com.example.product.dto.ProductTypeDto;
import com.example.product.dto.ProductTypeUpdateRequestDto;
import com.example.product.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productType")
@RequiredArgsConstructor
@Slf4j
public class ProductTypeRestController {

    private final ProductTypeService productTypeService;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<ProductTypeDto>> getAll(){
        log.info("Начался метод по получению всех типов продуктов");
        return ResponseEntity.ok(
                productTypeService.getAll()
        );
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> addProductType(@RequestBody ProductTypeCreateRequestDto dto){
        log.info("Начался метод по добавлению нового типа продукта");
        log.info("{}", dto);
        productTypeService.createProductType(dto);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> updateProductType(@RequestBody ProductTypeUpdateRequestDto dto){
        log.info("Начался метод по обновлению  типа продукта с ID::%d".formatted(dto.id()));
        log.info("{}", dto);
        productTypeService.updateProductType(dto);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin("*")
    @PostMapping("/{productTypeId:\\d+}/delete")
    public ResponseEntity<Void> updateProductType(@PathVariable(name = "productTypeId") Long productTypeId){
        log.info("Начался метод по удалению типа продукта с ID::%d".formatted(productTypeId));
        productTypeService.deleteProductType(productTypeId);
        return ResponseEntity.noContent().build();
    }
}
