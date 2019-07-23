package inventorymanagementserver.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/insert")
    public Category insert(@RequestBody Category category) {
        return categoryService.insert(category);
    }

    @GetMapping("/findById/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @PostMapping("/update")
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
