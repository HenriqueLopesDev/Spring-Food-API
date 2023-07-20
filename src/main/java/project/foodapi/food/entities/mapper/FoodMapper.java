package project.foodapi.food.entities.mapper;

import project.foodapi.food.entities.Food;
import project.foodapi.food.entities.dto.FoodRequestDTO;
import project.foodapi.food.entities.dto.FoodResponseDTO;

public class FoodMapper {

    public static Food ToEntity(FoodRequestDTO food){
        return new Food(food.getTitle(), food.getImage(), food.getPrice());
    }

    public static FoodResponseDTO toDTO(Food food){
        return new FoodResponseDTO(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
