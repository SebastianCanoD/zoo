package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Alimentacion;

@Service
public interface AlimentacionService {

	List<Alimentacion> buscarAlimentacion();

	void guardarAlimentacion(Alimentacion alimentacion);

	void eliminarAlimentacion(Integer id_alimentacion);

}
