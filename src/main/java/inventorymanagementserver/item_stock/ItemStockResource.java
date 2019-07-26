package inventorymanagementserver.item_stock;

import inventorymanagementserver.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apis/itemStock")
public class ItemStockResource {

    @Autowired
    private ItemStockFacadeService itemStockFacadeService;

    @PostMapping("/insert")
    public Item insertItemWithStock(@RequestBody Item item) {
        return itemStockFacadeService.inertItemWithStock(item);
    }

    @DeleteMapping("/deleteById/{itemId}")
    public void deleteItemWithStock(@PathVariable("itemId") Long itemId) {
        itemStockFacadeService.deleteItemWithStock(itemId);
    }
}
