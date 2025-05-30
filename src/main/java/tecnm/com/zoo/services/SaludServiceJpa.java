package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Salud;
import tecnm.com.zoo.repository.SaludRepository;

@Service
@Primary
public class SaludServiceJpa implements SaludService {

	@Autowired
	private SaludRepository repoSalud;

	@Override
	public List<Salud> buscarSalud() {
		// TODO Auto-generated method stub
		return repoSalud.findAll();
	}

	@Override
	public void guardarSalud(Salud salud) {
		repoSalud.save(salud);

	}

	@Override
	public void eliminarSalud(Integer id_reporte) {
		repoSalud.deleteById(id_reporte);

	}

}
