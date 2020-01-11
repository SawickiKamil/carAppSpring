package carApp.service;

import carApp.exception.ResourceNotFoundException;
import carApp.model.Car;
import carApp.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }


    public Car getCarById(long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("car by id: " + id + " not found"));
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(long id, Car car) {
        return carRepository.findById(id).map(c -> {
            c.setBrand(car.getBrand());
            c.setModel(car.getModel());
            c.setProductionYear(car.getProductionYear());
            c.setDescribe(car.getDescribe());
            return carRepository.save(c);
        }).orElseThrow(() -> new ResourceNotFoundException("car by id: " + id + " not found"));
    }

    public ResponseEntity<?> deleteCar(long id) {
        return carRepository.findById(id).map(c -> {
            carRepository.deleteById(id);
            return new ResponseEntity<>("car by id: " + id + " was deleted!", HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("car by id: " + id + " not found"));
    }
}
