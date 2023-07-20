package project.foodapi.food.entities;

import jakarta.persistence.*;
import lombok.*;
import project.foodapi.food.entities.dto.FoodRequestDTO;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public Food(FoodRequestDTO data){
        this.image = data.getImage();
        this.price = data.getPrice();
        this.title = data.getTitle();
    }
}
