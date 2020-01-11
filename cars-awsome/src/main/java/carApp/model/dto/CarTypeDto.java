package carApp.model.dto;

import java.util.ArrayList;
import java.util.List;

public class CarTypeDto {

    private String type;
    private List<String> cars = new ArrayList<>();

    public CarTypeDto(String type, List<String> cars) {
        this.type = type;
        this.cars = cars;
    }

    public CarTypeDto() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }
}
