package com.example.firstproject.api;

import com.example.firstproject.dto.CoffeeForm;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import com.example.firstproject.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CoffeeApiController {
//    @Autowired
//    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeService coffeeService;

    /// GET
    @GetMapping("/api/coffees")
    public List<Coffee> index() {
        return coffeeService.index();
    }

    @GetMapping("/api/coffees/{id}")
    public Coffee show(@PathVariable Long id) {
        return coffeeService.show(id);
    }
    /// PUSH
    @PostMapping("/api/coffees")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeForm dto) {
//        Coffee coffee = dto.toEntity();
        Coffee createdCoffee = coffeeService.create(dto);

        return (createdCoffee != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createdCoffee) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
//
    /// PATCH
    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeForm dto) {
//        Coffee coffee = dto.toEntity();
        Coffee updatedCoffee = coffeeService.update(id, dto);

        return (updatedCoffee != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updatedCoffee) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
//
    /// DELETE
    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id) {
//        Coffee coffee = coffeeRepository.findById(id).orElse(null);
        Coffee deletedCoffee = coffeeService.delete(id);

        return (deletedCoffee != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).body(deletedCoffee) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
