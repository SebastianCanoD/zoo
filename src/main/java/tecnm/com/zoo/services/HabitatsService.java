package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Habitats;

@Service
public interface HabitatsService {

	List<Habitats> buscarHabitats();

	void guardarHabitat(Habitats habitats);

	void eliminarHabitat(Integer id_habitat);

	Habitats buscarPorId(Integer id_habitat);

	List<Habitats> buscarPorNombre(String nombre);

}
