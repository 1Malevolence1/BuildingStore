package com.example.employee.controller;


import com.example.employee.dto.EmployeeCreateRequestDto;
import com.example.employee.dto.EmployeeResponseDto;
import com.example.employee.dto.EmployeeUpdateRequestDto;
import com.example.employee.exception.EmployeeNotFoundPositionException;
import com.example.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponseDto>> getAll() {
        log.info("начался метод по получению всех сотрудников");
        return ResponseEntity.ok(
                employeeService.getAll()
        );
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> addEmployee(@RequestBody EmployeeCreateRequestDto dto) {
        log.info("начался метод по добавлению нового сотрудника");
        log.info("{}", dto);
        employeeService.createEmployee(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> updateEmployee(@RequestBody EmployeeUpdateRequestDto dto) {
        log.info("начался метод по обновлению сотрудника");
        log.info("{}", dto);
        employeeService.updateEmployee(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/{employeeId:\\d+}/delete")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        log.info("начался метод по удалению сотрудника с ID::%d".formatted(employeeId));
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EmployeeNotFoundPositionException.class)
    public ResponseEntity<String> handlerSqlExceptionHelper(EmployeeNotFoundPositionException exception){
        return ResponseEntity.badRequest().body(exception.getError());
    }
}
