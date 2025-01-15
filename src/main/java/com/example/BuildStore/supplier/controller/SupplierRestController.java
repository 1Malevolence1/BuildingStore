package com.example.supplier.controller;


import com.example.supplier.dto.SupplierCreateRequestDto;
import com.example.supplier.dto.SupplierUpdateRequestDto;
import com.example.supplier.model.Supplier;
import com.example.supplier.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/supplier")
@RequiredArgsConstructor
@Slf4j
public class SupplierRestController {


    private final SupplierService supplierService;



    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<Supplier>> getAll() {
        log.info("начался метод по получению всех supplier");
        return ResponseEntity.ok(
                supplierService.getAll()
        );
    }


    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody SupplierCreateRequestDto dto) {
        log.info("начался метод по добавлению нового supplier");
        log.info("{}", dto);

        supplierService.add(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> update(@RequestBody SupplierUpdateRequestDto dto) {
        log.info("начался метод по обновлению supplier");
        log.info("{}", dto);
        supplierService.update(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/{supplierId:\\d+}/delete")
    public ResponseEntity<Void> delete(@PathVariable(name = "supplierId") Long supplierId) {
        log.info("начался метод по удалению supplier с ID::%d".formatted(supplierId));
        supplierService.delete(supplierId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerSqlExceptionHelper(NoSuchElementException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
