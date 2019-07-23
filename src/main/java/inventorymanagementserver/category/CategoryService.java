package inventorymanagementserver.category;

import java.util.List;

public interface CategoryService {
    Category insert(Category category);
    Category findById(Long id);
    List<Category> findAll();
    Category update(Category category);
    void deleteById(Long id);
}
