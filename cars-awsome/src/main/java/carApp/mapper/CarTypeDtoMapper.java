package carApp.mapper;

import carApp.model.Car;
import carApp.model.CarType;
import carApp.model.dto.CarTypeDto;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CarTypeDtoMapper implements Mapper<CarType, CarTypeDto> {

    @Override
    public CarTypeDto map(CarType from) {

        List<String> cars = from.getCars()
                .stream()
                .map(CarsToString.INSTANCE)
                .collect(Collectors.toList());


        return new CarTypeDto(from.getTitle(), cars);
    }

    @Override
    public CarType revers(CarTypeDto to) {

        return new CarType(to.getType(), new HashSet<>());
    }

    private enum CarsToString implements Function<Car, String> {
        INSTANCE;

        @Override
        public String apply(Car car) {
            return car.getBrand();
        }
    }

}
