package carApp.repository;

import carApp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("select c from Car c where c.id = ?1") //JPQL
    Car getCarById(long id);

}
