package project.foodapi.food.useCases;

import lombok.AllArgsConstructor;
import lombok.Setter;
import project.foodapi.food.entities.Food;
import project.foodapi.food.repository.FoodRepository;

@Setter
@AllArgsConstructor
public class FindById {

    private final FoodRepository repository;

    public Food execute(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Food not found"));
    }
}
