package controller;

import entity.Modelss;
import entity.VehicleProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ModelService;
import service.VehicleProductionService;

import java.util.List;
import java.util.Optional;



@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ModelService modelService;
    @Autowired
    private VehicleProductionService vehicleProductionService;

    // Admin Page
    @GetMapping("")
    public String adminPage() {
        return "subjects/adminPage";
    }

    // CRUD Category
    @GetMapping("/Model")
    public String viewCategoriesPage(org.springframework.ui.Model model) {
        List<Model> modelList = modelService.getAllCategories();
        model.addAttribute("categoriesList", modelList);
        return "subjects/categories";
    }

    @GetMapping("/createModel")
    public String createCategory(Model model) {
        model.addAttribute("categories", new Modelss());
        return "subjects/categoriesAdd";
    }

    @PostMapping("/createModel")
    public String saveCategory(@ModelAttribute("categories") Model model) {
        modelService.addCategory(model);
        return "redirect:/admin/Model";
    }

    @GetMapping("/editModel/{id}")
    public String editCategory(@PathVariable int id, org.springframework.ui.Model model) {
        Optional<Model> category = modelService.getCategoryById(id);
        category.ifPresent(value -> model.addAttribute("categories", value));
        return "subjects/editCategoryPage";
    }

    @PostMapping("/updateModel/{id}")
    public String updateCategory(@PathVariable int id, @ModelAttribute("categories") Model model) {

        modelService.addCategory(model);
        return "redirect:/admin/Model";
    }

    @GetMapping("/deleteModel/{id}")
    public String deleteCategory(@PathVariable int id) {
        modelService.getCategoryById(id).ifPresent(modelService::removeCategory);
        return "redirect:/admin/Model";
    }

    // CRUD Product
    @GetMapping("/viewProducts")
    public String viewProductsPage(org.springframework.ui.Model model) {
        List<VehicleProduction> vehicleProductionList = vehicleProductionService.getAllProducts();
        model.addAttribute("productsList", vehicleProductionList);
        return "subjects/products";
    }

    @GetMapping("/createProducts")
    public String createProductsPage(org.springframework.ui.Model model) {
        model.addAttribute("products", new VehicleProduction());
        model.addAttribute("categoriesList", modelService.getAllCategories());
        return "subjects/productsAdd";
    }
    @PostMapping("/createProducts")
    public String saveProducts(@ModelAttribute("products") VehicleProduction vehicleProduction) {
        vehicleProductionService.addProduct(vehicleProduction);
        return "redirect:/admin/viewProducts";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProductPage(org.springframework.ui.Model model, @PathVariable Long id) {
        Optional<VehicleProduction> product = vehicleProductionService.getProductById(id);
        product.ifPresent(value -> model.addAttribute("product", value));
        model.addAttribute("categoriesList", modelService.getAllCategories());
        return "subjects/editProductPage";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute("product") VehicleProduction vehicleProduction) {
        vehicleProduction.setId(id);
        vehicleProductionService.addProduct(vehicleProduction);
        return "redirect:/admin/viewProducts";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        vehicleProductionService.getProductById(id).ifPresent(vehicleProductionService::deleteProduct);
        return "redirect:/admin/viewProducts";
    }
}

