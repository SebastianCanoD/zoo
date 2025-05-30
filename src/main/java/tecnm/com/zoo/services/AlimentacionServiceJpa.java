package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Alimentacion;
import tecnm.com.zoo.repository.AlimentacionRepository;

@Service
@Primary
public class AlimentacionServiceJpa implements AlimentacionService {

	@Autowired
	private AlimentacionRepository repoAlimentacion;

	@Override
	public List<Alimentacion> buscarAlimentacion() {
		// TODO Auto-generated method stub
		return repoAlimentacion.findAll();
	}

	@Override
	public void guardarAlimentacion(Alimentacion alimentacion) {
		repoAlimentacion.save(alimentacion);

	}

	@Override
	public void eliminarAlimentacion(Integer id_alimentacion) {
		repoAlimentacion.deleteById(id_alimentacion);

	}

}
