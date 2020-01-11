package carApp.controller.dto;


import carApp.model.dto.CarTypeDto;
import carApp.service.dto.CarTypeDtoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarTypeDtoRestController {

    private CarTypeDtoService carTypeDtoService;

    public CarTypeDtoRestController(CarTypeDtoService carTypeDtoService) {
        this.carTypeDtoService = carTypeDtoService;
    }

    @GetMapping("/api/cars/type/dto")
    public List<CarTypeDto> getCarTypes() {
        return carTypeDtoService.getCarTypes();
    }

}
