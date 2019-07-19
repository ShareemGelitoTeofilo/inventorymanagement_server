package inventorymanagementserver.item;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.category.Category;
import inventorymanagementserver.category.CategoryRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ItemServiceTest extends ServerMainClassTest {

    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void registerItem() throws Exception {
        Item item = itemService.registerItem(createItem());
        assertNotNull(item);
    }

    @Test
    public void findItemById() throws Exception {
        Long id = createSavedItem().getId();
        Item item = itemService.findById(id);
        assertNotNull(item);
    }

    @Test
    public void findItemByName() throws Exception {
        String name = createSavedItem().getName();
        Item item = itemService.findByName(name);
        assertNotNull(item);
    }

    @Test
    public void findAllItem() throws Exception {
        List<Item> items = itemService.findAll();
        assertFalse(items.isEmpty());
    }

    @Test
    public void updateItem() throws Exception {
        Item item = createSavedItem();
        item.setName("namehahaheh");
        item.setBrand("brand");
        item.setCategory(createCategory());
        item.setColor("color");
        item.setPrice(123);
        item = itemService.updateItem(item);
        assertNotNull(item);
    }

    private Item createItem() {
        String name = UUID.randomUUID().toString();
        return new Item(
                name, "brand", "color",
                createCategory(), 123.00
        );
    }

    private Item createSavedItem() {
        String name = UUID.randomUUID().toString();
        return itemRepository.save(new Item(
                name, "brand", "color",
                createCategory(), 123.00
        ));
    }

    private Category createCategory() {
        String name = UUID.randomUUID().toString();
        Category category = new Category(name);
        return categoryRepository.save(category);
    }

}
