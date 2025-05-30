package tecnm.com.zoo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Animales;
import tecnm.com.zoo.repository.AnimalesRepository;

@Service
@Primary
public class AnimalesServiceJpa implements AnimalesService {

	@Autowired
	private AnimalesRepository repoAnimales;

	@Override
	public List<Animales> buscarAnimales() {
		// TODO Auto-generated method stub
		return repoAnimales.findAll();
	}

	@Override
	public Animales buscarPorId(Integer id_animal) {
		// TODO Auto-generated method stub
		Optional<Animales> optional = repoAnimales.findById(id_animal);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Animales> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return repoAnimales.findByNombreContainingIgnoreCase(nombre);
	}

	@Override
	public void guardarAnimal(Animales animales) {
		// TODO Auto-generated method stub
		repoAnimales.save(animales);
	}

	@Override
	public void eliminarAnimal(Integer id_animal) {
		// TODO Auto-generated method stub
		repoAnimales.deleteById(id_animal);
	}

//	@Override
//	public List<Animales> buscarPorHabitat(Integer id_habitat) {
//		return repoAnimales.findByHabitats(id_habitat);
//	}

}
