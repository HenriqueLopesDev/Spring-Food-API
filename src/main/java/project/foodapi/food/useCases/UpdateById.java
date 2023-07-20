package project.foodapi.food.useCases;

import lombok.AllArgsConstructor;
import lombok.Setter;
import project.foodapi.food.entities.Food;
import project.foodapi.food.repository.FoodRepository;

@Setter
@AllArgsConstructor
public class UpdateById {

    private final FoodRepository repository;

    public Food execute(Long id, Food food){
        Food foundFood = repository.findById(id).orElseThrow(() -> new RuntimeException("Food not found"));
        foundFood.setTitle(food.getTitle());
        foundFood.setImage(food.getImage());
        foundFood.setPrice(food.getPrice());
        return repository.save(foundFood);
    }
}
