package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Visitantes;
import tecnm.com.zoo.repository.VisitantesRepository;

@Service
@Primary
public class VisitantesServiceJpa implements VisitantesService {

	@Autowired
	private VisitantesRepository repoVisitantes;

	@Override
	public List<Visitantes> buscarVisitantes() {
		// TODO Auto-generated method stub
		return repoVisitantes.findAll();
	}

	@Override
	public void guardarVisitante(Visitantes visitantes) {
		repoVisitantes.save(visitantes);

	}

	@Override
	public void eliminarVisitante(Integer id_visitante) {
		repoVisitantes.deleteById(id_visitante);

	}

}
