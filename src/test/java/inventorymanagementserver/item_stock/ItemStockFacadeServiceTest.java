package inventorymanagementserver.item_stock;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import inventorymanagementserver.item.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class ItemStockFacadeServiceTest extends ServerMainClassTest {
    @Autowired
    private ItemStockFacadeService itemStockFacadeService;
    @Autowired
    private TestHelper testHelper;

    @Test
    public void insertItemWithStock() {
        Item item = testHelper.getItem();
        item = itemStockFacadeService.inertItemWithStock(item);
        assertNotNull(item);
    }
}
