package inventorymanagementserver.item;

import java.util.List;

public interface ItemService {
    Item registerItem(Item item) throws Exception;
    Item findById(Long id) throws Exception;
    Item findByName(String name) throws Exception;
    List<Item> findAll() throws Exception;
}
