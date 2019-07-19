package inventorymanagementserver.stock;

import inventorymanagementserver.ServerMainClassTest;
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
    StockRepository stockRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void saveStock(){
        Stock stock = stockRepository.save(createStock());
        assertNotNull(stock);
    }

    @Test
    public void findStockById(){
        Stock stock = createSavedStock();
        stock = stockRepository.findById(stock.getId()).get();
        assertNotNull(stock);
    }

    @Test
    public void findStockByItem(){
        Stock stock = createSavedStock();
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
        Stock stock = createSavedStock();
        stockRepository.deleteById(stock.getId());
    }


    private Stock createStock(){
        return new Stock(createItem(), 12);
    }

    private Stock createSavedStock(){
        return stockRepository.save(
                new Stock(createItem(), 12)
        );
    }

    private Item createItem(){
        Category category = categoryRepository.save(new Category("name"));
        return itemRepository.save(new Item(
                "name", "brand", "color",
                category, 123.00
        ));
    }


}
