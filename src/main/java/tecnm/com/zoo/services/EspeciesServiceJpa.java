package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Especies;
import tecnm.com.zoo.repository.EspeciesRepository;

@Service
@Primary
public class EspeciesServiceJpa implements EspeciesService {

	@Autowired
	private EspeciesRepository repoEspecies;

	@Override
	public List<Especies> buscarEspecies() {
		// TODO Auto-generated method stub
		return repoEspecies.findAll();

	}

	@Override
	public void guardarEspecie(Especies especies) {
		repoEspecies.save(especies);
	}

	@Override
	public void eliminarEspecie(Integer id_especie) {
		repoEspecies.deleteById(id_especie);

	}

	@Override
	public List<Especies> obtenerTodas() {
		return repoEspecies.findAll();
	}

}
