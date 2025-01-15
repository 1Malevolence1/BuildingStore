package com.example.customers.controller;


import com.example.customers.dto.CustomerCreateRequestDto;
import com.example.customers.dto.CustomerResponseDto;
import com.example.customers.dto.CustomerUpdateRequestDto;
import com.example.customers.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerRestController {


    private final CustomerService customerService;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponseDto>> getAll() {
        log.info("начался метод по получению всех клиентов");
        return ResponseEntity.ok(
                customerService.getAllCustomers()
        );
    }

    @GetMapping("/{customerId:\\d+}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable(name = "customerId") Long customerId) {
        log.info("начался метод по получению клиента по ID::%d".formatted(customerId));
        return ResponseEntity.ok(
                customerService.getCustomer(customerId)
        );
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> addEmployee(@RequestBody CustomerCreateRequestDto dto) {
        log.info("начался метод по добавлению нового клиента");
        log.info("{}", dto);
        customerService.createCustomer(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> updateEmployee(@RequestBody CustomerUpdateRequestDto dto) {
        log.info("начался метод по обновлению клиента");
        log.info("{}", dto);
        customerService.updateCustomer(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/{customerId:\\d+}/delete")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(name = "customerId") Long customerId) {
        log.info("начался метод по удалению клиента с ID::%d".formatted(customerId));
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerSqlExceptionHelper(NoSuchElementException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
