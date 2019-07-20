package inventorymanagementserver.stock;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import inventorymanagementserver.item.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class StockServiceTest extends ServerMainClassTest {

    @Autowired
    StockService stockService;
    @Autowired
    TestHelper testHelper;

    @Test
    public void insertStock(){
        Stock stock = testHelper.createStock();
        assertNotNull(stockService.insert(stock));
    }

    @Test
    public void findStockById() throws Exception {
        Stock stock = testHelper.createSavedStock();
        assertNotNull(stockService.findById(stock.getId()));
    }

    @Test
    public void findStockByItem() throws Exception {
        Item item = testHelper.createSavedStock().getItem();
        assertNotNull(stockService.findByItemId(item.getId()));
    }




}
