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

public class ItemRepositoryTest extends ServerMainClassTest {


    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void saveItem(){
        Item item = createItem();
        item = itemRepository.save(item);
        assertNotNull(item);
    }

    @Test
    public void findItemById(){
        Item item = createSavedItem();
        item = itemRepository.findById(item.getId()).get();
        assertNotNull(item);
    }

    @Test
    public void findItemByName(){
        Item item = createSavedItem();
        item = itemRepository.findByName(item.getName());
        assertNotNull(item);
    }

    @Test
    public void findAllItems(){
        List<Item> items = itemRepository.findAll();
        assertFalse(items.isEmpty());
    }

    @Test
    public void updateItem(){
        Item item = createSavedItem();
        item.setName("new name");
        item.setBrand("new brand");
        item.setColor("new color");
        item.setCategory(createCategory());
        item.setPrice(123.23);
        item = itemRepository.save(item);
        assertNotNull(item);
    }

    @Test
    public void deleteItemById(){
        Item item = createSavedItem();
        itemRepository.delete(item);
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
        Category category = new Category("name");
        return categoryRepository.save(category);
    }

}
