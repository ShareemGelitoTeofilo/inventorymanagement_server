package inventorymanagementserver.item;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import inventorymanagementserver.category.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ItemRepositoryTest extends ServerMainClassTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private TestHelper testHelper;

    @Test
    public void save(){
        Item item = testHelper.getItem();
        item = itemRepository.save(item);
        assertNotNull(item);
    }

    @Test
    public void findById(){
        Item item = testHelper.createItem();
        item = itemRepository.findById(item.getId()).get();
        assertNotNull(item);
    }

    @Test
    public void findByName(){
        Item item = testHelper.createItem();
        item = itemRepository.findByName(item.getName());
        assertNotNull(item);
    }

    @Test
    public void findAll(){
        List<Item> items = itemRepository.findAll();
        assertFalse(items.isEmpty());
    }

    @Test
    public void update(){
        Item itemToUpdate = testHelper.createItem();
        Item item = testHelper.getItem();
        itemToUpdate.setName(item.getName());
        itemToUpdate.setBrand(item.getBrand());
        itemToUpdate.setColor(item.getColor());
        itemToUpdate.setCategory(testHelper.createCategory());
        itemToUpdate.setPrice(item.getPrice());
        itemToUpdate = itemRepository.save(itemToUpdate);
        assertNotNull(itemToUpdate);
    }

    @Test
    public void deleteById(){
        Item item = testHelper.createItem();
        itemRepository.deleteById(item.getId());
    }

    @Test
    public void findAllByCategory() {
        Category category = testHelper.createItem().getCategory();
        List<Item> items = itemRepository.findAllByCategory(category);
        assertFalse(items.isEmpty());
    }
}
