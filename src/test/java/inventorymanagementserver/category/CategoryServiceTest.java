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
    public void insert() {
        Category category = testHelper.createCategory();
        category = categoryService.insert(category);
        assertNotNull(category);
    }

    @Test
    public void findById() {
        Category category = testHelper.createSavedCategory();
        category = categoryService.findById(category.getId());
        assertNotNull(category);
    }

    @Test
    public void findAll() {
        List<Category> categories = categoryService.findAll();
        assertFalse(categories.isEmpty());
    }

    @Test
    public void update() {
        Category category = testHelper.createSavedCategory();
        String name = UUID.randomUUID().toString();
        category.setName(name);
        category = categoryService.update(category);
        assertNotNull(category);
    }

    @Test
    public void deleteById() {
        Category category = testHelper.createSavedCategory();
        categoryService.deleteById(category.getId());
    }
}
