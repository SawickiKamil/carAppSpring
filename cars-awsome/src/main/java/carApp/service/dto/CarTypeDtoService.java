package carApp.service.dto;

import carApp.mapper.CarTypeDtoMapper;
import carApp.model.dto.CarTypeDto;
import carApp.repository.CarTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarTypeDtoService {

    private CarTypeRepository carTypeRepository;
    private CarTypeDtoMapper carTypeDtoMapper;

    public CarTypeDtoService(CarTypeRepository carTypeRepository, CarTypeDtoMapper carTypeDtoMapper) {
        this.carTypeRepository = carTypeRepository;
        this.carTypeDtoMapper = carTypeDtoMapper;
    }

    public List<CarTypeDto> getCarTypes() {
        List<CarTypeDto> carTypeDtos = new ArrayList<>();
        carTypeRepository
                .findAll()
                .forEach(t -> carTypeDtos.add(carTypeDtoMapper.map(t)));
        return carTypeDtos;
    }
}
