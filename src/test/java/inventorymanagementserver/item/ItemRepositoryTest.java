package inventorymanagementserver.item;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ItemRepositoryTest extends ServerMainClassTest {


    @Autowired
    ItemRepository itemRepository;
    @Autowired
    TestHelper testHelper;

    @Test
    public void saveItem(){
        Item item = testHelper.createItem();
        item = itemRepository.save(item);
        assertNotNull(item);
    }

    @Test
    public void findItemById(){
        Item item = testHelper.createSavedItem();
        item = itemRepository.findById(item.getId()).get();
        assertNotNull(item);
    }

    @Test
    public void findItemByName(){
        Item item = testHelper.createSavedItem();
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
        Item item = testHelper.createSavedItem();
        item.setName("new name");
        item.setBrand("new brand");
        item.setColor("new color");
        item.setCategory(testHelper.createCategory());
        item.setPrice(123.23);
        item = itemRepository.save(item);
        assertNotNull(item);
    }

    @Test
    public void deleteItemById(){
        Item item = testHelper.createSavedItem();
        itemRepository.delete(item);
    }

}
