package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import repository.ModelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;

    public List<Model> getAllCategories() {
        return modelRepository.findAll();
    }

    public void addCategory(Model category) {
        modelRepository.save(category);
    }

    public void removeCategory(Model category) {
        modelRepository.delete(category);
    }

    public Optional<Model> getCategoryById(int id) {
        return modelRepository.findById(id);
    }
}
