package com.example.product.controller;


import com.example.product.dto.ProductCreateRequestDto;
import com.example.product.dto.ProductResponseDto;
import com.example.product.service.ProductService;
import com.example.product.dto.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*") // Allow all origins (you can specify specific origins)
public class ProducerRestController {

    private final ProductService productService;



    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateRequestDto dto){
        log.info("Начался метод по добавлению продукта в базу данных");
        log.info("{}", dto);
        productService.create(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @GetMapping("/{productId:\\d+}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable(name = "productId") Long productId){
        log.info("Начался метод по получению продукта по ID::%d".formatted(productId));
        return ResponseEntity.ok(
                productService.findProduct(productId)
        );
    }

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDto>> getAll(){
        log.info("Начался метод по получению всех продуктов");
        return ResponseEntity.ok(
                productService.findAllProduct()
        );
    }
    @CrossOrigin("*")
    @PostMapping("/{productId:\\d+}/delete")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "productId") Long id){
        log.info("Начался метод по удалению продукта с ID::%d".formatted(id));
        productService.deleteProductBuId(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductUpdateRequestDto dto){
        log.info("Начался метод по обновлению продукта с ID::%d".formatted(dto.id()));
        productService.updateProduct(dto);
        return ResponseEntity.noContent().build();
    }
}
