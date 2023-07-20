package project.foodapi.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.foodapi.food.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
