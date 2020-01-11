package carApp.repository;

import carApp.model.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Long> {


    @Query("select t from CarType t where t.title = ?1")
    CarType findCarTypeByTitle(String title);

    @Query("select t from CarType t where t.title = ?1")
    Optional<CarType> findCarTypeByTitleOptional(String title);

}
