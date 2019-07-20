package inventorymanagementserver;

import inventorymanagementserver.category.Category;
import inventorymanagementserver.category.CategoryRepository;
import inventorymanagementserver.item.Item;
import inventorymanagementserver.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TestHelper {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public Item createSavedItem() {
        String name = UUID.randomUUID().toString();
        return itemRepository.save(new Item(
                name, "brand", "color",
                createCategory(), 123.00
        ));
    }

    public Category createCategory() {
        Category category = new Category("name");
        return categoryRepository.save(category);
    }
}
