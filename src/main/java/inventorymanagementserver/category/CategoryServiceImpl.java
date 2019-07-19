package inventorymanagementserver.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category registerCategory(Category category) throws Exception {
        Category existingCategory = categoryRepository.findByName(category.getName());
        if(existingCategory != null){
            throw new Exception("Category already exist");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) throws Exception {
        String message = String.format("Category with ID %s not found", id);
        return categoryRepository.findById(id)
                .orElseThrow(() -> new Exception(message));
    }
}
