package carApp.controller.dto;


import carApp.commons.CreatorXLS;
import carApp.model.dto.CarDto;
import carApp.service.dto.CarDtoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class CarDtoRestController {

    private CarDtoService carDtoService;

    public CarDtoRestController(CarDtoService carDtoService) {
        this.carDtoService = carDtoService;
    }

    @GetMapping("/api/cars/dto")
    public List<CarDto> getCars() {
        return carDtoService.getCars();
    }

    @PostMapping("/api/cars/dto")
    public ResponseEntity<CarDto> createCar (CarDto carDto) {
        CarDto result = carDtoService.create(carDto);
        if(result == null) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/api/cars/dto/xls")
    public List<CarDto> getCarsToXlsFile() {

        //todo przerobić aby plik pobrac z serwera
        List<CarDto> series = carDtoService.getCars();
        CreatorXLS<CarDto> creatorXLS = new CreatorXLS<>(CarDto.class);
        try {
            creatorXLS.createFile(series, "src/main/resources/", "cars");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | IOException e) {
            e.printStackTrace();
            return null;
        }

        return series;
    }
}
