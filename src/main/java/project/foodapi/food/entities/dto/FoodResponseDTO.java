package project.foodapi.food.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.foodapi.food.entities.Food;

@Getter
@Setter
@AllArgsConstructor
public class FoodResponseDTO {
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public FoodResponseDTO(Food food){
        setId(food.getId());
        setTitle(food.getTitle());
        setPrice(food.getPrice());
        setImage(food.getImage());
    }
}
