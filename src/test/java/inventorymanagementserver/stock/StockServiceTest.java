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

    @Test
    public void findAllStocks() throws Exception {
        List<Stock> stocks = stockService.findAll();
        assertFalse(stocks.isEmpty());
    }

    @Test
    public void updateStock() throws Exception {
        Stock stock = testHelper.createSavedStock();
        stock.setQuantity(12);
        stock = stockService.update(stock);
        assertNotNull(stock);
    }

    @Test
    public void deleteStockById() throws Exception {
        Stock stock = testHelper.createSavedStock();
        stockService.deleteById(stock.getId());
    }
}
