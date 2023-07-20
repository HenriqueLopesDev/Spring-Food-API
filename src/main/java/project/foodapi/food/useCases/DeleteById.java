package project.foodapi.food.useCases;

import lombok.AllArgsConstructor;
import lombok.Setter;
import project.foodapi.food.repository.FoodRepository;

@Setter
@AllArgsConstructor
public class DeleteById {

    private final FoodRepository repository;

    public void execute(Long id){
        repository.deleteById(id);
    }
}
