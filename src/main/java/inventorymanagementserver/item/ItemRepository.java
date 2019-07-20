package inventorymanagementserver.item;

import inventorymanagementserver.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String name);
    List<Item> findAllByCategory(Category category);
}
