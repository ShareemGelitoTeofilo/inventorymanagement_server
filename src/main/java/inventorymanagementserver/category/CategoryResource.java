package inventorymanagementserver.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/register")
    public Category registerCategory(@RequestBody Category category) throws Exception {
        return categoryService.registerCategory(category);
    }

    @GetMapping("/findById/{id}")
    public Category findById(@PathVariable Long id) throws Exception {
        return categoryService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Category> findAll() throws Exception {
        return categoryService.findAll();
    }

    @PostMapping("/update")
    public Category updateCategory(@RequestBody Category category) throws Exception {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) throws Exception {
        categoryService.deleteById(id);
    }



}
