package inventorymanagementserver.category;

import inventorymanagementserver.ServerMainClassTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class CategoryServiceTest extends ServerMainClassTest {

    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void registerCategory(){
        Category category = createCategory();
        category = categoryService.registerCategory(category);
        assertNotNull(category);
    }

    private Category createCategory() {
        return new Category("name");
    }
    private Category createSavedCategory() {
        return categoryRepository.save(new Category("name"));
    }

}
