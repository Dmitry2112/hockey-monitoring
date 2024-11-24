package org.example.hockeymonitoring.modules.category;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getList() {
        return categoryService.getList();
    }

    @GetMapping("/{id}")
    public Category getOne(@PathVariable Long id) {
        return categoryService.getOne(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @PatchMapping("/{id}")
    public Category patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return categoryService.patch(id, patchNode);
    }

    @DeleteMapping("/{id}")
    public Category deleteCategory(@PathVariable Long id) {
        return categoryService.delete(id);
    }
}
