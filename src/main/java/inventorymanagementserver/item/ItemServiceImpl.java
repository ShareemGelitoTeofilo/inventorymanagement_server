package inventorymanagementserver.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item registerItem(Item item) throws Exception {
        Item existingItem = itemRepository.findByName(item.getName());
        if(existingItem != null){
            throw new Exception("Item with the a same name already exist");
        }
        return itemRepository.save(item);
    }
}
