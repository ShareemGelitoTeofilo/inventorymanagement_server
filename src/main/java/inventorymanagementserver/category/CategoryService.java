package inventorymanagementserver.category;

public interface CategoryService {
    Category registerCategory(Category category) throws Exception;
    Category findById(Long id) throws Exception;
}
