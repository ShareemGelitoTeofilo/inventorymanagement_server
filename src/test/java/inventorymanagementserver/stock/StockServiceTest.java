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

    TestHelper testHelper = TestHelper.getTestHelperInstance();

    @Test
    public void insertStock(){
        Stock stock = createStock();
        assertNotNull(stockService.insert(stock));
    }

    private Stock createStock() {
        Item item = testHelper.createSavedItem();
        int quantity = 12;
        return new Stock(item, quantity);
    }


}
