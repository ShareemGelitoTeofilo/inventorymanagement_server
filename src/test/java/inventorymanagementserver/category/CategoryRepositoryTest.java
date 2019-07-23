package inventorymanagementserver.category;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CategoryRepositoryTest extends ServerMainClassTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TestHelper testHelper;

    @Test
    public void save(){
        Category category = testHelper.createCategory();
        category = categoryRepository.save(category);
        assertNotNull(category);
    }

    @Test
    public void findById(){
        Category category = testHelper.createSavedCategory();
        category = categoryRepository.findById(category.getId()).get();
        assertNotNull(category);
    }

    @Test
    public void findByName(){
        Category category = testHelper.createSavedCategory();
        category = categoryRepository.findByName(category.getName());
        assertNotNull(category);
    }

    @Test
    public void findAll(){
        List<Category> categories = categoryRepository.findAll();
        assertFalse(categories.isEmpty());
    }

    @Test
    public void update(){
        Category category = testHelper.createSavedCategory();
        String name = UUID.randomUUID().toString().substring(0, 8);
        category.setName(name);
        category = categoryRepository.save(category);
        assertNotNull(category);
    }

    @Test
    public void deleteById(){
        Category category = testHelper.createSavedCategory();
        categoryRepository.deleteById(category.getId());
    }
}
