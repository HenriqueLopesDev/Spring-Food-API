package project.foodapi.food.useCases;

import lombok.AllArgsConstructor;
import lombok.Setter;
import project.foodapi.food.entities.Food;
import project.foodapi.food.repository.FoodRepository;

import java.util.List;

@Setter
@AllArgsConstructor
public class FindAll {

    private final FoodRepository repository;

    public List<Food> execute(){
        return repository.findAll();
    }

}
