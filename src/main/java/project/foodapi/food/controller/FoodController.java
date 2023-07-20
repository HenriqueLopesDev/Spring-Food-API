package project.foodapi.food.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import project.foodapi.food.entities.Food;
import project.foodapi.food.entities.dto.FoodRequestDTO;
import project.foodapi.food.entities.dto.FoodResponseDTO;
import project.foodapi.food.repository.FoodRepository;
import project.foodapi.food.useCases.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("food")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @GetMapping
    ResponseEntity<List<FoodResponseDTO>> findAll(){

        List<FoodResponseDTO> foodList = new FindAll(repository).execute().stream().map(FoodResponseDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(foodList);
    }

    @GetMapping("{id}")
    ResponseEntity<FoodResponseDTO> findById(@PathVariable Long id){
        try{
            Food foundFood = new FindById(repository).execute(id);
            FoodResponseDTO foodDTO = new FoodResponseDTO(foundFood);
            return ResponseEntity.status(HttpStatus.OK).body(foodDTO);
        } catch (RuntimeException error){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity<FoodResponseDTO> save(@Valid @RequestBody FoodRequestDTO data){
        Food food = new Food(data);
        Food dbFood = new Create(repository).execute(food);
        FoodResponseDTO foodResponse = new FoodResponseDTO(dbFood);
        return ResponseEntity.status(HttpStatus.CREATED).body(foodResponse);
    }

    @PutMapping("{id}")
    ResponseEntity<FoodResponseDTO> updateById(@PathVariable Long id, @Valid @RequestBody FoodRequestDTO data){
        try{
            Food food = new Food(data);
            Food dbFood = new UpdateById(repository).execute(id, food);
            FoodResponseDTO foodResponse = new FoodResponseDTO(dbFood);
            return ResponseEntity.status(HttpStatus.OK).body(foodResponse);
        } catch (RuntimeException error){
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id){
        new DeleteById(repository).execute(id);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException requestErrors){
        Map<String, String> errors = new HashMap<>();
        requestErrors.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
