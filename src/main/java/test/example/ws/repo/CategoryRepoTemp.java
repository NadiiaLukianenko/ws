package test.example.ws.repo;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.stereotype.Component;
import test.example.ws.model.Category;

import java.util.List;

@Log4j2
@Component
public class CategoryRepoTemp {

    public Category findCategoryById(String categoryId) {
        return Category.builder().id(categoryId).category("Category123").points(List.of("1", "2", "3")).build();
    }

    public List<Category> findAllCategories() {
        Category category1 = Category.builder().id("1").category("Category1").points(List.of("a", "b", "c")).build();
        Category category2 = Category.builder().id("2").category("Category2").points(List.of("d", "e", "f")).build();
        Category category3 = Category.builder().id("3").category("Category3").points(List.of("g", "h", "i")).build();

        return List.of(category1, category2, category3);
    }

    public Category createCategory(Category category) {
        return Category.builder().id(category.getId()).category(category.getCategory()).points(category.getPoints()).build();
    }

    public Category updateCategory(Category category) {
        return Category.builder().id(category.getId()).category(category.getCategory()).points(category.getPoints()).build();
    }

    public void deleteCategory(String id) {
        log.log(Level.WARN, "Deleted category with ID = {id}");
    }

}
