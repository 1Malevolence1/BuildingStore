package com.example.inventory.controller;

import com.example.inventory.dto.InventoryCreateRequestDto;
import com.example.inventory.dto.InventoryResponseDto;
import com.example.inventory.dto.InventoryUpdateRequestDto;
import com.example.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
@Slf4j
public class RestInventoryController {
    private final InventoryService inventoryService;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<InventoryResponseDto>> getAll(){
        log.info("Начался метод по возращению всех inventory");
        return ResponseEntity.ok(
                inventoryService.getAll()
        );
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> addInventory(@RequestBody InventoryCreateRequestDto dto){
        log.info("Начался метод по добавлению inventory");
        log.info("{}", dto);
        inventoryService.addInventory(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> addInventory(@RequestBody InventoryUpdateRequestDto dto){
        log.info("Начался метод по обновлению inventory");
        log.info("{}", dto);
        inventoryService.updateInventory(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/{inventoryId:\\d+}/delete")
    public ResponseEntity<Void> addInventory(@PathVariable(name = "inventoryId") Long inventoryId){
        log.info("Начался метод по удалению inventory с ID::%d".formatted(inventoryId));
        inventoryService.deleteInventory(inventoryId);
        return ResponseEntity.noContent().build();
    }
}

