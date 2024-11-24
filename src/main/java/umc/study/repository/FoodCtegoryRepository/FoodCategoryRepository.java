package umc.study.repository.FoodCtegoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.FoodCategory;

import java.util.List;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
    boolean existById(List<Long> values);
}
