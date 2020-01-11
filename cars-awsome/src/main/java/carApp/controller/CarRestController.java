package carApp.controller;

import carApp.model.Car;
import carApp.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarRestController {

    private CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/cars")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping("/api/cars/{id}")
    public Car getCars(@PathVariable long id) {
        return carService.getCarById(id);
    }

    @PostMapping("/api/cars")
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @PutMapping("/api/cars/{id}")
    public Car updateCarType(@PathVariable long id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/api/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable long id) {
        return carService.deleteCar(id);
    }
}
