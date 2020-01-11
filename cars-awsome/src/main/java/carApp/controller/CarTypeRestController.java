package carApp.controller;

import carApp.model.CarType;
import carApp.service.CarTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarTypeRestController {

    private CarTypeService carTypeService;

    public CarTypeRestController(CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
    }

    @GetMapping("/api/cars/type")
    public List<CarType> getCarTypes() {
        return carTypeService.getCarTypes();
    }

    @PostMapping("/api/cars/type")
    public CarType createCarType(@RequestBody CarType carType) {
        return carTypeService.createCarType(carType);
    }

    @PutMapping("/api/cars/type/{id}")
    public CarType updateCarType(@PathVariable long id, @RequestBody CarType carType) {
        return carTypeService.updateCarType(id, carType);
    }

    @DeleteMapping("/api/cars/type/{id}")
    public ResponseEntity<?> deleteCarType(@PathVariable long id) {
        return carTypeService.deleteCarType(id);
    }

}
