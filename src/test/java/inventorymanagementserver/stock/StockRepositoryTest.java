package inventorymanagementserver.stock;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
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
    public void save(){
        Stock stock = stockRepository.save(testHelper.getStock());
        assertNotNull(stock);
    }

    @Test
    public void findById(){
        Stock stock = testHelper.createStock();
        stock = stockRepository.findById(stock.getId()).get();
        assertNotNull(stock);
    }

    @Test
    public void findByItemId(){
        Stock stock = testHelper.createStock();
        Long itemId = stock.getItem().getId();
        stock = stockRepository.findByItemId(itemId);
        assertNotNull(stock);
    }

    @Test
    public void findAll(){
        List<Stock> stocks = stockRepository.findAll();
        assertFalse(stocks.isEmpty());
    }

    @Test
    public void deletedStockById(){
        Stock stock = testHelper.createStock();
        stockRepository.deleteById(stock.getId());
    }
}
