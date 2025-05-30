package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Cuidadores;

@Service
public interface CuidadoresService {

	List<Cuidadores> buscarCuidadores();
    void guardarCuidador(Cuidadores cuidadores);
    void eliminarCuidador(Integer id_cuidador);
}
