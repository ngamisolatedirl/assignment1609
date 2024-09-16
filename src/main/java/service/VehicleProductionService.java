package service;

import entity.VehicleProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VehicleProductionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleProductionService {
    @Autowired
    VehicleProductionRepository PR;
    public List<VehicleProduction> getAllProducts() {return PR.findAll();}
    public void addProduct(VehicleProduction vehicleProduction) {PR.save(vehicleProduction);}
    public void deleteProduct(VehicleProduction vehicleProduction) {PR.delete(vehicleProduction);}
    public Optional<VehicleProduction> getProductById(Long id) {return PR.findById(id);}
}
