package tecnm.com.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tecnm.com.zoo.model.Animales;

public interface AnimalesRepository extends JpaRepository<Animales, Integer> {
	List<Animales> findByNombreContainingIgnoreCase(String nombre);

//	List<Animales> findByHabitats(Integer id_habitat);
}
