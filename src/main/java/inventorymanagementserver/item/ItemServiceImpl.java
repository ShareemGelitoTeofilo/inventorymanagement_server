package inventorymanagementserver.item;

import inventorymanagementserver.category.Category;
import inventorymanagementserver.category.CategoryRepository;
import inventorymanagementserver.exception.InventoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Item insert(Item item) {
        Item existingItemWithSameName = itemRepository.findByName(item.getName());
        if(existingItemWithSameName != null){
            throw new InventoryException("Item with the a same name already exist");
        }
        return itemRepository.save(item);
    }

    @Override
    public Item findById(Long id) {
        String message = String.format("Item with the ID %s not found", id);
        return itemRepository.findById(id)
                .orElseThrow(()-> new InventoryException(message));
    }

    @Override
    public Item findByName(String name) {
        Item item = itemRepository.findByName(name);
        if(item == null){
            String message = String.format("Item with name %s not found", name);
            throw new InventoryException(message);
        }
        return item;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        if(items.isEmpty()){
            throw new InventoryException("No item/s found");
        }
        return items;
    }

    @Override
    public Item update(Item item) {
        checkIfCategoryExist(item.getCategory());
        Item existingItemWithSameName = itemRepository.findByName(item.getName());
        if(existingItemWithSameName != null && !existingItemWithSameName.equals(item)){
            String message = String.format("Item name is already taken");
            throw new InventoryException(message);
        }
        return itemRepository.save(item);
    }

    @Override
    public void deleteById(Long id) {
        if(!itemRepository.existsById(id)){
            String message = String.format("Item with ID %s not found", id);
            throw new InventoryException(message);
        }
        itemRepository.deleteById(id);
    }

    private void checkIfCategoryExist(Category category) {
        if(!categoryRepository.existsById(category.getId())){
            throw new InventoryException("Category no longer exist");
        }
    }
}
