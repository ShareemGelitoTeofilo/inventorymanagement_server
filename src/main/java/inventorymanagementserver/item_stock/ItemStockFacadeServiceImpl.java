package inventorymanagementserver.item_stock;

import inventorymanagementserver.item.Item;
import inventorymanagementserver.item.ItemService;
import inventorymanagementserver.stock.Stock;
import inventorymanagementserver.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemStockFacadeServiceImpl implements ItemStockFacadeService {
    @Autowired
    private ItemService itemService;
    @Autowired
    private StockService stockService;

    @Override
    public Item inertItemWithStock(Item item) {
        item = itemService.insert(item);
        stockService.insert(new Stock(item, 0));
        return item;
    }

    @Override
    public void deleteItemWithStock(Long itemId) {
        Stock stock = stockService.findByItemId(itemId);
        stockService.deleteById(stock.getId());
        itemService.deleteById(itemId);
    }
}
