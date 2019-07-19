package inventorymanagementserver.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Category> findAll() throws Exception {
        List<Category> categories = categoryRepository.findAll();
        if(categories == null || categories.isEmpty()){
            throw new Exception("No category found");
        }
        return categories;
    }

    @Override
    public Category updateCategory(Category category) throws Exception {
        findById(category.getId());
        Category existingCategoryWithSameName = categoryRepository.findByName(category.getName());
        if(existingCategoryWithSameName != null && !existingCategoryWithSameName.equals(category)){
            throw new Exception("Category name already taken");
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        findById(id);
        categoryRepository.deleteById(id);
    }
}
