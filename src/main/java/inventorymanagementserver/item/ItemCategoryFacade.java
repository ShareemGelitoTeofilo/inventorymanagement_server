package inventorymanagementserver.item;

import inventorymanagementserver.category.Category;
import inventorymanagementserver.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemCategoryFacade {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    public void checkIfCategoryExist(Category category) throws Exception {
        Category existingCategory = categoryRepository.findById(category.getId())
                .orElseThrow(()-> new Exception("Category no longer exist"));
    }

    public boolean checkIfCategoryHasRelationship(Category category) {
       List<Item> itemsUsingTheCategory = itemRepository.findAllByCategory(category);
       return !itemsUsingTheCategory.isEmpty();
    }
}
