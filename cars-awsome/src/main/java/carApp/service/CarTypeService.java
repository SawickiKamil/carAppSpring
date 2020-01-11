package carApp.service;

import carApp.exception.ResourceNotFoundException;
import carApp.model.CarType;
import carApp.repository.CarTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypeService {

    private CarTypeRepository carTypeRepository;

    public CarTypeService(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }

    public List<CarType> getCarTypes() {
        return carTypeRepository.findAll();
    }

    public CarType createCarType(CarType carType) {
        return carTypeRepository.save(carType);
    }

    public CarType updateCarType(long id, CarType carType) {
        return carTypeRepository.findById(id).map(t -> {
            t.setTitle(carType.getTitle());
            return carTypeRepository.save(t);
        }).orElseThrow(() -> new ResourceNotFoundException("carType id: " + id + " not found"));
    }

    public ResponseEntity<?> deleteCarType(long id) {
        return carTypeRepository.findById(id).map(t -> {
            carTypeRepository.deleteById(id);
            return new ResponseEntity<>("carType by id: " + id + " was deleted!", HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("carType id: " + id + " not found"));
    }
}
