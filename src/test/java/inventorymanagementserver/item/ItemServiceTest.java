package inventorymanagementserver.item;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.category.Category;
import inventorymanagementserver.category.CategoryRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

public class ItemServiceTest extends ServerMainClassTest {

    @Autowired
    ItemService itemService;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void registerItem() throws Exception {
        Item item = itemService.registerItem(createItem());
        assertNotNull(item);
    }

    private Item createItem() {
        String name = UUID.randomUUID().toString();
        return new Item(
                name, "brand", "color",
                createCategory(), 123.00
        );
    }

    private Category createCategory() {
        String name = UUID.randomUUID().toString();
        Category category = new Category(name);
        return categoryRepository.save(category);
    }

}
