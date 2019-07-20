package inventorymanagementserver.stock;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import inventorymanagementserver.category.Category;
import inventorymanagementserver.category.CategoryRepository;
import inventorymanagementserver.item.Item;
import inventorymanagementserver.item.ItemRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class StockRepositoryTest extends ServerMainClassTest {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private TestHelper testHelper;

    @Test
    public void saveStock(){
        Stock stock = stockRepository.save(testHelper.createStock());
        assertNotNull(stock);
    }

    @Test
    public void findStockById(){
        Stock stock = testHelper.createSavedStock();
        stock = stockRepository.findById(stock.getId()).get();
        assertNotNull(stock);
    }

    @Test
    public void findStockByItem(){
        Stock stock = testHelper.createSavedStock();
        Long itemId = stock.getItem().getId();
        stock = stockRepository.findByItemId(itemId);
        assertNotNull(stock);
    }

    @Test
    public void findAllStock(){
        List<Stock> stocks = stockRepository.findAll();
        assertFalse(stocks.isEmpty());
    }

    @Test
    public void deletedStockById(){
        Stock stock = testHelper.createSavedStock();
        stockRepository.deleteById(stock.getId());
    }
}
