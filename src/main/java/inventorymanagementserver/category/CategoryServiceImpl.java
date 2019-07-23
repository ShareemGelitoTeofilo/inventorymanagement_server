package inventorymanagementserver.category;

import inventorymanagementserver.exception.InventoryException;
import inventorymanagementserver.item.Item;
import inventorymanagementserver.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final static String NOT_FOUND = "Category/s not found";

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Category insert(Category category) {
        Category existingCategory = categoryRepository.findByName(category.getName());
        if (existingCategory != null) {
            throw new InventoryException("Category already exist");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new InventoryException(NOT_FOUND));
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new InventoryException(NOT_FOUND);
        }
        return categories;
    }

    @Override
    public Category update(Category category) {
        if (!categoryRepository.existsById(category.getId())) {
            throw new InventoryException(NOT_FOUND);
        }
        Category existingCategoryWithSameName = categoryRepository.findByName(category.getName());
        if (existingCategoryWithSameName != null && !existingCategoryWithSameName.equals(category)) {
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
