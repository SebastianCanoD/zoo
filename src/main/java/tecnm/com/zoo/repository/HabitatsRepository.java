package tecnm.com.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tecnm.com.zoo.model.Habitats;

public interface HabitatsRepository extends JpaRepository<Habitats, Integer> {
	List<Habitats> findByNombreContainingIgnoreCase(String nombre);
}
