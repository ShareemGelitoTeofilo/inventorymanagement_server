package inventorymanagementserver.category;

import inventorymanagementserver.ServerMainClassTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CategoryServiceTest extends ServerMainClassTest {

    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void registerCategory() throws Exception {
        Category category = createCategory();
        category = categoryService.registerCategory(category);
        assertNotNull(category);
    }

    @Test
    public void findRegisterById() throws Exception {
        Category category = createSavedCategory();
        Long id = category.getId();
        category = categoryService.findById(id);
        assertNotNull(category);
    }

    @Test
    public void findAllCategories() throws Exception {
        List<Category> categories = categoryService.findAll();
        assertFalse(categories.isEmpty());
    }

    @Test
    public void updateCategory() throws Exception {
        Category category = createSavedCategory();
        category.setName("updated name a");
        category = categoryService.updateCategory(category);
        assertNotNull(category);
    }

    @Test
    public void deleteCategoryById() throws Exception {
        Category category = createSavedCategory();
        categoryService.deleteById(category.getId());
    }


    private Category createCategory() {
        String name = UUID.randomUUID().toString();
        return new Category(name);
    }
    private Category createSavedCategory() {
        String name = UUID.randomUUID().toString();
        return categoryRepository.save(new Category(name));
    }

}
