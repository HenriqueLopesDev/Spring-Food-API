package project.foodapi.food.useCases;

import lombok.AllArgsConstructor;
import lombok.Setter;
import project.foodapi.food.entities.Food;
import project.foodapi.food.repository.FoodRepository;

@Setter
@AllArgsConstructor
public class Create {

    private final FoodRepository repository;

    public Food execute(Food food){
        return repository.save(food);
    }
}
