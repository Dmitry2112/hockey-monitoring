package org.example.hockeymonitoring.modules.category;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.shared.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public Response<List<Category>> getList() {
        List<Category> categories = categoryService.getList();
        return new Response<>(categories);
    }

    @GetMapping("/{id}")
    public Response<Category> getOne(@PathVariable Long id) {
        Category category = categoryService.getOne(id);
        return new Response<>(category);
    }

    @PostMapping
    public Response<Category> create(@RequestBody Category category) {
        Category createdCategory = categoryService.create(category);
        return new Response<>(createdCategory);
    }

    @PatchMapping("/{id}")
    public Response<Category> patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        Category category = categoryService.patch(id, patchNode);
        return new Response<>(category);
    }

    @DeleteMapping("/{id}")
    public Response<Category> deleteCategory(@PathVariable Long id) {
        Category category = categoryService.delete(id);
        return new Response<>(category);
    }
}
