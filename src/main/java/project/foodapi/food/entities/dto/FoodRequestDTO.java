package project.foodapi.food.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodRequestDTO{
    @NotBlank(message = "Título é obrigatório")
    private String title;
    @NotBlank(message = "Imagem não pode estar vazio")
    private String image;
    @NotNull(message = "Preço não pode estar vazio")
    @Positive(message = "Preço deve ser um número positivo")
    Integer price;
}
