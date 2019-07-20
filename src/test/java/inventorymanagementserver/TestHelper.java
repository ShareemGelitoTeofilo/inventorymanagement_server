package inventorymanagementserver;

import inventorymanagementserver.category.Category;
import inventorymanagementserver.category.CategoryRepository;
import inventorymanagementserver.item.Item;
import inventorymanagementserver.item.ItemRepository;
import inventorymanagementserver.stock.Stock;
import inventorymanagementserver.stock.StockRepository;
import inventorymanagementserver.user.User;
import inventorymanagementserver.user.UserRepository;
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
    @Autowired
    private UserRepository userRepository;


    public Item createItem() {
        String name = UUID.randomUUID().toString();
        return new Item(
                name, "brand", "color",
                createSavedCategory(), 123.00
        );
    }

    public Item createSavedItem() {
        return itemRepository.save(createItem());
    }

    public Category createCategory() {
        return new Category("name");
    }

    public Category createSavedCategory() {
        return categoryRepository.save(createCategory());
    }

    public Stock createStock() {
        Item item = createSavedItem();
        int quantity = 12;
        return new Stock(item, quantity);
    }

    public Stock createSavedStock() {
        return stockRepository.save(createStock());
    }

    public User createUser(){
        String name = UUID.randomUUID().toString();
        String username = UUID.randomUUID().toString();
        return new User( name,"address", username,"password");
    }

    public User createSavedUser(){
        return userRepository.save(createUser());
    }
}
