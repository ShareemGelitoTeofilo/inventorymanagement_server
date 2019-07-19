package inventorymanagementserver.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemCategoryFacade itemCategoryFacade;

    @Override
    public Item registerItem(Item item) throws Exception {
        Item existingItem = itemRepository.findByName(item.getName());
        if(existingItem != null){
            throw new Exception("Item with the a same name already exist");
        }
        return itemRepository.save(item);
    }

    @Override
    public Item findById(Long id) throws Exception {
        String message = String.format("Item with the ID %s not found", id);
        return itemRepository.findById(id)
                .orElseThrow(()-> new Exception(message));
    }

    @Override
    public Item findByName(String name) throws Exception {
        Item item = itemRepository.findByName(name);
        if(item == null){
            String message = String.format("Item with name %s not found", name);
            throw new Exception(message);
        }
        return item;
    }

    @Override
    public List<Item> findAll() throws Exception {
        List<Item> items = itemRepository.findAll();
        if(items == null || items.isEmpty()){
            throw new Exception("No item/s found");
        }
        return items;
    }

    @Override
    public Item updateItem(Item item) throws Exception {
        Item existingItemWithSameName = itemRepository.findByName(item.getName());
        if(existingItemWithSameName != null && !existingItemWithSameName.equals(item)){
            String message = String.format("Item name is already taken");
            throw new Exception(message);
        }
        itemCategoryFacade.checkIfCategoryExist(item.getCategory());
        return itemRepository.save(item);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        findById(id);
        itemRepository.deleteById(id);
    }
}
