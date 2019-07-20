package inventorymanagementserver.category;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CategoryRepositoryTest extends ServerMainClassTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TestHelper testHelper;

    @Test
    public void saveCategory(){
        Category category = testHelper.createCategory();
        category = categoryRepository.save(category);
        assertNotNull(category);
    }

    @Test
    public void findCategoryById(){
        Category category = testHelper.createSavedCategory();
        category = categoryRepository.findById(category.getId()).get();
        assertNotNull(category);
    }

    @Test
    public void findCategoryByName(){
        Category category = testHelper.createSavedCategory();
        category = categoryRepository.findByName(category.getName());
        assertNotNull(category);
    }

    @Test
    public void findAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        assertFalse(categories.isEmpty());
    }

    @Test
    public void updateCategory(){
        Category category = testHelper.createSavedCategory();
        category = categoryRepository.save(category);
        assertNotNull(category);
    }

    @Test
    public void deleteCategoryById(){
        Category category = testHelper.createSavedCategory();
        categoryRepository.deleteById(category.getId());
    }
}
