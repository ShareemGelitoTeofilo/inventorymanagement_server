package inventorymanagementserver.category;

import java.util.List;

public interface CategoryService {
    Category registerCategory(Category category) throws Exception;
    Category findById(Long id) throws Exception;
    List<Category> findAll() throws Exception;
    Category updateCategory(Category category) throws Exception;
    void deleteById(Long id) throws Exception;
}
