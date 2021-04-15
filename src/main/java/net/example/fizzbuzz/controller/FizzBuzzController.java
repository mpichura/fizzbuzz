package net.example.fizzbuzz.controller;

import net.example.fizzbuzz.service.FizzBuzzService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

    public static final String FIZZBUZZ_RESOURCE = "/fizzbuzz-resource";
    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping(path = FIZZBUZZ_RESOURCE)
    public ResponseEntity<String> getFizzBuzzResource(@RequestParam final int startFrom, @RequestParam final int endAt) {

        try {
            final String result = fizzBuzzService.step3FizzBuzz(startFrom, endAt);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.getMessage());
        }

    }
}
