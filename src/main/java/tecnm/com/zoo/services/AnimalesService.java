package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Animales;

@Service
public interface AnimalesService {

	List<Animales> buscarAnimales();

	Animales buscarPorId(Integer id_animal);

	List<Animales> buscarPorNombre(String nombre);

	void guardarAnimal(Animales animales);

	void eliminarAnimal(Integer id_animal);

}
