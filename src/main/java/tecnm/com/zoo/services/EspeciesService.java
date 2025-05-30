package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Especies;

@Service
public interface EspeciesService {

	List<Especies> buscarEspecies();

	void guardarEspecie(Especies especies);

	void eliminarEspecie(Integer id_especie);

	List<Especies> obtenerTodas();

}
