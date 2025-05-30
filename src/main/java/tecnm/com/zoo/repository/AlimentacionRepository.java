package tecnm.com.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tecnm.com.zoo.model.Alimentacion;

public interface AlimentacionRepository extends JpaRepository<Alimentacion, Integer> {

}
