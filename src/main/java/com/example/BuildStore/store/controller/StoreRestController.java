package com.example.store.controller;


import com.example.store.service.StoreService;
import com.example.store.store.StoreCreateDtoRequest;
import com.example.store.store.StoreResponseDto;
import com.example.store.store.StoreUpdateDtoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/store")
@RequiredArgsConstructor
@Slf4j
public class StoreRestController {

    private final StoreService storeService;


    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<StoreResponseDto>> getAll(){
        log.info("получение всех store. Дата: {} ", LocalDateTime.now());
        return ResponseEntity.ok(storeService.getAll());
    }


    @CrossOrigin("*")
    @GetMapping("/{storeId:\\d+}")
    public ResponseEntity<StoreResponseDto> getStore(@PathVariable(name = "storeId") Long storeId){
        log.info("получение store по ID::%d. Дата: {} ", LocalDateTime.now());
        return ResponseEntity.ok(storeService.getStore(storeId));
    }


    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> addStore(@RequestBody StoreCreateDtoRequest dto){
        log.info("добавление store. Дата: {} ", LocalDateTime.now());
        storeService.createStore(dto);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> updateStore(@RequestBody StoreUpdateDtoRequest dto){
        log.info("обновление store с ID::%d. Дата: {} ", LocalDateTime.now());
        storeService.updateStore(dto);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin("*")
    @PostMapping("/{storeId:\\d+}/delete")
    public ResponseEntity<StoreResponseDto> deleteStore(@PathVariable(name = "storeId") Long storeId){
        log.info("удаление store с ID::%d. Дата: {}".formatted(storeId), LocalDateTime.now());
        storeService.deleteStore(storeId);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerNoSuchElementException(NoSuchElementException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
