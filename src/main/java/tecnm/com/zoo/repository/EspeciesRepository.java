package tecnm.com.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tecnm.com.zoo.model.Especies;

public interface EspeciesRepository extends JpaRepository<Especies, Integer> {
}
