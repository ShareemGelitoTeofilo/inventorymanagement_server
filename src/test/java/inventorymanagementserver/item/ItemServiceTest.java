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
    public void registerItem() throws Exception {
        Item item = testHelper.createItem();
        item = itemService.registerItem(item);
        assertNotNull(item);
    }

    @Test
    public void findItemById() throws Exception {
        Long id = testHelper.createSavedItem().getId();
        Item item = itemService.findById(id);
        assertNotNull(item);
    }

    @Test
    public void findItemByName() throws Exception {
        String name = testHelper.createSavedItem().getName();
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
        Item item = testHelper.createSavedItem();
        item.setName("namehahaheh");
        item.setBrand("brand");
        item.setCategory(testHelper.createSavedCategory());
        item.setColor("color");
        item.setPrice(123);
        item = itemService.updateItem(item);
        assertNotNull(item);
    }

    @Test
    public void deleteItem() throws Exception {
        Item item = testHelper.createSavedItem();
        itemService.deleteById(item.getId());
    }


}
