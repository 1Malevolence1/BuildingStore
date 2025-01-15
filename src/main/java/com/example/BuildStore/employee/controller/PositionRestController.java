package com.example.employee.controller;


import com.example.employee.dto.PositionCreateRequestDto;
import com.example.employee.dto.PositionResponseDto;
import com.example.employee.dto.PositionUpdateRequestDto;
import com.example.employee.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/position")
@RequiredArgsConstructor
@Slf4j
public class PositionRestController {

    private final PositionService positionService;


    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<PositionResponseDto>> getAll(){
        log.info("Начался метод по получению всех позиций работников");
        return ResponseEntity.ok(
                positionService.getAll()
        );
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> addPosition(@RequestBody PositionCreateRequestDto dto){
        log.info("Начался метод по добавлению позиции");
        log.info("{}", dto);
        positionService.createPosition(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> updatePosition(@RequestBody PositionUpdateRequestDto dto){
        log.info("Начался метод по обновлению позиции");
        log.info("{}", dto);
        positionService.updatePosition(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/{positionId:\\d+}/delete")
    public ResponseEntity<Void> deletePosition(@PathVariable(name = "positionId") Long positionId){
       log.info("Начался метод по удалению позиции с ID::%d".formatted(positionId));
        positionService.deletePosition(positionId);
        return ResponseEntity.noContent().build();
    }
}
