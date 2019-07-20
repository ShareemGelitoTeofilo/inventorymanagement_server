package inventorymanagementserver;

import inventorymanagementserver.category.Category;
import inventorymanagementserver.category.CategoryRepository;
import inventorymanagementserver.item.Item;
import inventorymanagementserver.item.ItemRepository;
import inventorymanagementserver.stock.Stock;
import inventorymanagementserver.stock.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TestHelper {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StockRepository stockRepository;


    public Item createItem() {
        String name = UUID.randomUUID().toString();
        return new Item(
                name, "brand", "color",
                createSavedCategory(), 123.00
        );
    }

    public Item createSavedItem() {
        String name = UUID.randomUUID().toString();
        return itemRepository.save(new Item(
                name, "brand", "color",
                createSavedCategory(), 123.00
        ));
    }

    public Category createCategory() {
        return new Category("name");
    }

    public Category createSavedCategory() {
        Category category = new Category("name");
        return categoryRepository.save(category);
    }

    private Stock createStock() {
        Item item = createSavedItem();
        int quantity = 12;
        return new Stock(item, quantity);
    }

    private Stock createSavedStock() {
        Item item = createSavedItem();
        int quantity = 12;
        return stockRepository.save(
                new Stock(item, quantity)
        );
    }
}
