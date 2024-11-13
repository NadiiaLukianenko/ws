package test.example.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.example.ws.model.Category;
import test.example.ws.repo.CategoryRepoTemp;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepoTemp repo;

    @Autowired
    public CategoryService(CategoryRepoTemp repo) {
        this.repo = repo;
    }

    public Category getCategoryById(String id) {
        return repo.findCategoryById(id);
    }

    public List<Category> getCategories() {
        return repo.findAllCategories();
    }

    public Category getCategory(String categoryTitle) {
        return null;
    }

    public Category createCategory(Category category) {
        return repo.createCategory(category);
    }

    public Category updateCategory(Category category) {
        return repo.updateCategory(category);
    }

    public void deleteCategory(String id) {
        repo.deleteCategory(id);
    }

}
