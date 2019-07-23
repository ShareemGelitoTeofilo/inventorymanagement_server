package inventorymanagementserver.category;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CategoryServiceTest extends ServerMainClassTest {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TestHelper testHelper;

    @Test
    public void registerCategory() {
        Category category = testHelper.createCategory();
        category = categoryService.registerCategory(category);
        assertNotNull(category);
    }

    @Test
    public void findRegisterById() {
        Category category = testHelper.createSavedCategory();
        category = categoryService.findById(category.getId());
        assertNotNull(category);
    }

    @Test
    public void findAllCategories() {
        List<Category> categories = categoryService.findAll();
        assertFalse(categories.isEmpty());
    }

    @Test
    public void updateCategory() {
        Category category = testHelper.createSavedCategory();
        String name = UUID.randomUUID().toString();
        category.setName(name);
        category = categoryService.updateCategory(category);
        assertNotNull(category);
    }

    @Test
    public void deleteCategoryById() {
        Category category = testHelper.createSavedCategory();
        categoryService.deleteById(category.getId());
    }
}
