package inventorymanagementserver.category;

import inventorymanagementserver.exception.InventoryException;
import inventorymanagementserver.item.Item;
import inventorymanagementserver.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Category registerCategory(Category category) {
        Category existingCategory = categoryRepository.findByName(category.getName());
        if(existingCategory != null){
            throw new InventoryException("Category already exist");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        String message = String.format("Category with ID %s not found", id);
        return categoryRepository.findById(id)
                .orElseThrow(() -> new InventoryException(message));
    }

    @Override
    public List<Category> findAll()  {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()){
            throw new InventoryException("No category found");
        }
        return categories;
    }

    @Override
    public Category updateCategory(Category category) {
        if (!categoryRepository.existsById(category.getId()))    {
            throw new InventoryException("Category doesn't exist");
        }
        Category existingCategoryWithSameName = categoryRepository.findByName(category.getName());
        if(existingCategoryWithSameName != null && !existingCategoryWithSameName.equals(category)){
            throw new InventoryException("Category name already taken");
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        Category category = findById(id);
        if (checkIfCategoryHasRelationship(category)) {
            throw new InventoryException("This category is used by an item");
        }
        categoryRepository.deleteById(category.getId());
    }

    private boolean checkIfCategoryHasRelationship(Category category) {
        List<Item> itemsUsingTheCategory = itemRepository.findAllByCategory(category);
        return !itemsUsingTheCategory.isEmpty();
    }
}
