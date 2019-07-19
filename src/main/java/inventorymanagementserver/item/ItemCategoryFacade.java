package inventorymanagementserver.item;

import inventorymanagementserver.category.Category;
import inventorymanagementserver.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ItemCategoryFacade {

    @Autowired
    private CategoryRepository categoryRepository;

    public void checkIfCategoryExist(Category category) throws Exception {
        Category existingCategory = categoryRepository.findById(category.getId())
                .orElseThrow(()-> new Exception("Category no longer exist"));
    }
}
