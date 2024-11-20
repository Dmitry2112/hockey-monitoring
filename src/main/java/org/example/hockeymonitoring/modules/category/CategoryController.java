package org.example.hockeymonitoring.modules.category;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("save_category")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PutMapping("update_category")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("delete_category/{id}")
    @Transactional
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
