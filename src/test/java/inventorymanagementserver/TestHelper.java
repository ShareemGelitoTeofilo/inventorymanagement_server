package inventorymanagementserver;

import inventorymanagementserver.category.Category;
import inventorymanagementserver.category.CategoryRepository;
import inventorymanagementserver.item.Item;
import inventorymanagementserver.item.ItemRepository;
import inventorymanagementserver.stock.Stock;
import inventorymanagementserver.stock.StockRepository;
import inventorymanagementserver.user.User;
import inventorymanagementserver.user.UserRepository;
import inventorymanagementserver.user.UserType;
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

    public Item getItem() {
        String name = UUID.randomUUID().toString().substring(0,8);
        String brand = UUID.randomUUID().toString().substring(0,8);
        String color = UUID.randomUUID().toString().substring(0,8);
        double price = (Math.random() * 200) + 1;
        return new Item(
                name, brand, color,
                createCategory(), price
        );
    }

    public Item createItem() {
        return itemRepository.save(getItem());
    }

    public Category getCategory() {
        String name = UUID.randomUUID().toString().substring(0, 8);
        return new Category(name);
    }

    public Category createCategory() {
        return categoryRepository.save(getCategory());
    }

    public Stock getStock() {
        Item item = createItem();
        int quantity = 12;
        return new Stock(item, quantity);
    }

    public Stock createStock() {
        return stockRepository.save(getStock());
    }

    public User getUser(){
        String name = UUID.randomUUID().toString();
        String username = UUID.randomUUID().toString();
        UserType[] userTypes = UserType.values();
        UserType userType = userTypes[(int)(Math.random() * userTypes.length)];
        return new User( name,"address", username,"password", userType);
    }

    public User createUser(){
        return userRepository.save(getUser());
    }
}
