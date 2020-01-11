package carApp.model.dto;

public class CarDto {

    private String brand;
    private String model;
    private String productionYear;
    private String describe;
    private String carType;

    public CarDto() {
    }

    private CarDto(Builder b) {
        this.brand = b.brand;
        this.model = b.model;
        this.productionYear = b.productionYear;
        this.describe = b.describe;
        this.carType = b.carType;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public String getDescribe() {
        return describe;
    }

    public String getCarType() {
        return carType;
    }

    public static class Builder {
        private String brand;
        private String model;
        private String productionYear;
        private String describe;
        private String carType;

        public Builder() {
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder productionYear(String productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Builder describe(String describe) {
            this.describe = describe;
            return this;
        }

        public Builder carType(String carType) {
            this.carType = carType;
            return this;
        }

        public CarDto build() {
            return new CarDto(this);
        }
    }


}
