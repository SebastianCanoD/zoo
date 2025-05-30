package tecnm.com.zoo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Habitats;
import tecnm.com.zoo.repository.HabitatsRepository;

@Service
@Primary
public class HabitatsServiceJpa implements HabitatsService {

	@Autowired
	private HabitatsRepository repoHabitats;

	@Override
	public List<Habitats> buscarHabitats() {
		// TODO Auto-generated method stub
		return repoHabitats.findAll();
	}

	@Override
	public void guardarHabitat(Habitats habitats) {
		repoHabitats.save(habitats);

	}

	@Override
	public void eliminarHabitat(Integer id_habitat) {
		repoHabitats.deleteById(id_habitat);

	}

	@Override
	public Habitats buscarPorId(Integer id_habitat) {
		// TODO Auto-generated method stub
		Optional<Habitats> optional = repoHabitats.findById(id_habitat);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Habitats> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return repoHabitats.findByNombreContainingIgnoreCase(nombre);
	}

}
