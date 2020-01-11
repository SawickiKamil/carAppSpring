package carApp.service.dto;

import carApp.mapper.CarMapper;
import carApp.mapper.CarTypeDtoMapper;
import carApp.model.Car;
import carApp.model.CarType;
import carApp.model.dto.CarDto;
import carApp.repository.CarRepository;
import carApp.repository.CarTypeRepository;
import carApp.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDtoService {

    private static final Logger logger = LoggerFactory.getLogger(CarDtoService.class);

    private CarRepository carRepository;
    private CarMapper carMapper;
    private CarTypeDtoMapper carTypeDtoMapper;
    private CarTypeRepository carTypeRepository;
    private TagRepository tagRepository;


    public CarDtoService(CarRepository carRepository, CarMapper carMapper, CarTypeRepository carTypeRepository, TagRepository tagRepository) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
        this.carTypeRepository = carTypeRepository;
        this.tagRepository = tagRepository;
    }

    public List<CarDto> getCars() {
        List<CarDto> carDtos = new ArrayList<>();
        carRepository.findAll().forEach(c -> {
            carDtos.add(carMapper.map(c));
        });
        return carDtos;
    }

    //
    public CarDto create(CarDto carDto) {
        logger.info("Received carDta{}", carDto);
        Car car = new Car();
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setDescribe(carDto.getDescribe());
        car.setProductionYear(carDto.getProductionYear());

        //todo sposób pierwszy
//        Optional<CarType> carOptional = carTypeRepository.findCarTypeByTitleOptional(carDto.getCarType());
//        carOptional.ifPresent(car::setCarType);

        //todo sposób 2
        CarType carType = carTypeRepository.findCarTypeByTitle(carDto.getCarType());
        if (carType == null) {
            logger.error("Error while getting carType!");
            return null;
        }

        logger.info("Try to save Car to DB", car);
        car.setCarType(carType);
        Car result = carRepository.save(car);
        if (result == null) {
            logger.error("Error while saving to data base!");
            return null;
        }
        return carMapper.map(car);
    }

    //todo pełny CRUD na reszte API
}
