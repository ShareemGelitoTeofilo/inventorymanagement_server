package inventorymanagementserver.category;

import inventorymanagementserver.ServerMainClassTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CategoryRepositoryTest extends ServerMainClassTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void saveCategory(){
        Category category = createCategory();
        category = categoryRepository.save(category);
        assertNotNull(category);
    }

    @Test
    public void findCategoryById(){
        Category category = createSavedCategory();
        category = categoryRepository.findById(category.getId()).get();
        assertNotNull(category);
    }

    @Test
    public void findAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        assertFalse(categories.isEmpty());
    }

    @Test
    public void updateCategory(){
        Category category = createSavedCategory();
        category.setName("new name");
        category = categoryRepository.save(category);
        assertNotNull(category);
    }

    @Test
    public void deleteCategoryById(){
        Category category = createSavedCategory();
        categoryRepository.deleteById(category.getId());
    }
    

    private Category createSavedCategory() {
        return categoryRepository.save(new Category("name"));
    }


    private Category createCategory() {
        return new Category("name");
    }

}
