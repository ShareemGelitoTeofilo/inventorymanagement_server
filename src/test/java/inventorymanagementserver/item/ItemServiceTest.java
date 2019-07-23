package inventorymanagementserver.item;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ItemServiceTest extends ServerMainClassTest {

    @Autowired
    private ItemService itemService;
    @Autowired
    private TestHelper testHelper;

    @Test
    public void registerItem() {
        Item item = testHelper.getItem();
        item = itemService.insert(item);
        assertNotNull(item);
    }

    @Test
    public void findItemById() {
        Long id = testHelper.createItem().getId();
        Item item = itemService.findById(id);
        assertNotNull(item);
    }

    @Test
    public void findItemByName() {
        String name = testHelper.createItem().getName();
        Item item = itemService.findByName(name);
        assertNotNull(item);
    }

    @Test
    public void findAllItem() {
        List<Item> items = itemService.findAll();
        assertFalse(items.isEmpty());
    }

    @Test
    public void updateItem() {
        Item itemToUpdate = testHelper.createItem();
        Item item = testHelper.getItem();
        itemToUpdate.setName(item.getName());
        itemToUpdate.setBrand(item.getBrand());
        itemToUpdate.setCategory(testHelper.createCategory());
        itemToUpdate.setColor(item.getColor());
        itemToUpdate.setPrice(item.getPrice());
        itemToUpdate = itemService.update(itemToUpdate);
        assertNotNull(itemToUpdate);
    }

    @Test
    public void deleteItem() {
        Long id = testHelper.createItem().getId();
        itemService.deleteById(id);
    }


}
