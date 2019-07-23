package inventorymanagementserver.stock;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import inventorymanagementserver.item.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class StockServiceTest extends ServerMainClassTest {

    @Autowired
    private StockService stockService;
    @Autowired
    private TestHelper testHelper;

    @Test
    public void insert(){
        Stock stock = testHelper.getStock();
        assertNotNull(stockService.insert(stock));
    }

    @Test
    public void findById() {
        Stock stock = testHelper.createStock();
        assertNotNull(stockService.findById(stock.getId()));
    }

    @Test
    public void findByItemId() {
        Item item = testHelper.createStock().getItem();
        Stock stock = stockService.findByItemId(item.getId());
        assertNotNull(stock);
    }

    @Test
    public void findAll() {
        List<Stock> stocks = stockService.findAll();
        assertFalse(stocks.isEmpty());
    }

    @Test
    public void update() {
        Stock stock = testHelper.createStock();
        int quantity = 12;
        stock = stockService.update(stock.getId(), quantity);
        assertNotNull(stock);
    }

    @Test
    public void deleteById() {
        Stock stock = testHelper.createStock();
        stockService.deleteById(stock.getId());
    }
}
