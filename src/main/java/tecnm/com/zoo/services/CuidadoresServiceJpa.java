package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Cuidadores;
import tecnm.com.zoo.repository.CuidadoresRepository;

@Service
@Primary
public class CuidadoresServiceJpa implements CuidadoresService {

	@Autowired
	private CuidadoresRepository repoCuidadores;

	@Override
	public List<Cuidadores> buscarCuidadores() {
		// TODO Auto-generated method stub
		return repoCuidadores.findAll();
	}

	@Override
	public void guardarCuidador(Cuidadores cuidadores) {
		repoCuidadores.save(cuidadores);

	}

	@Override
	public void eliminarCuidador(Integer id_cuidador) {
		repoCuidadores.deleteById(id_cuidador);

	}

}
