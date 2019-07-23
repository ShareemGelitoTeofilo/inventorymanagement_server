package inventorymanagementserver.item;

import java.util.List;

public interface ItemService {
    Item insert(Item item);
    Item findById(Long id);
    Item findByName(String name);
    List<Item> findAll();
    Item update(Item item);
    void deleteById(Long id);
}
