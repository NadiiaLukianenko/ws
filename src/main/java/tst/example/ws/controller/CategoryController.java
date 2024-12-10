package tst.example.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tst.example.ws.controller.exception.CategoryNotFoundException;
import tst.example.ws.controller.exception.CategoryUnprocessableException;
import tst.example.ws.model.Category;
import tst.example.ws.service.CategoryService;
import java.util.List;

@RequestMapping("/category")
@Controller
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Category>> getCategoriesList(@CookieValue(name = "user_id", defaultValue = "default_user_id") String userId) {
        HttpCookie cookie = ResponseCookie.from("user_id", userId).path("/").build();
        return ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.SET_COOKIE,cookie.toString()).body(categoryService.getCategories());
    }

    @GetMapping(value = "/{category_title}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Category> getCategory(@PathVariable(value = "category_title") String categoryTitle,
                                              @CookieValue(name = "user_id", defaultValue = "default_user_id") String userId) {
        Category category = categoryService.getCategory(categoryTitle);
        if (category == null) throw new CategoryNotFoundException("Category " + categoryTitle + " not found");
        HttpCookie cookie = ResponseCookie.from("user_id", userId).path("/").build();
        return ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.SET_COOKIE,cookie.toString()).body(category);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category, @CookieValue(name = "user_id") String userId) {
        Category createdCategory = categoryService.createCategory(category);
        HttpCookie cookie = ResponseCookie.from("user_id", userId).path("/").build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .header(HttpHeaders.SET_COOKIE, cookie.toString()).body(createdCategory);
    }

    @PutMapping(value = "/{category_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "category_id") String categoryId,
                                                           @RequestBody Category category) {
        if (categoryId == null || category == null) throw new CategoryUnprocessableException("Category is unprocessable");
        Category updatedCategory = categoryService.updateCategory(category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{category_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteCategory(@PathVariable("category_id") String categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
