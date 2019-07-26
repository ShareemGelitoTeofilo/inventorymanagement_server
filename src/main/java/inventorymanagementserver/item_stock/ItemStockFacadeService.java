package inventorymanagementserver.item_stock;

import inventorymanagementserver.item.Item;

public interface ItemStockFacadeService {
    Item inertItemWithStock(Item item);
    void deleteItemWithStock(Long itemId);
}
