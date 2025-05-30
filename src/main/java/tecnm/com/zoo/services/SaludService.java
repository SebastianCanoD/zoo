package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Salud;

@Service
public interface SaludService {

	List<Salud> buscarSalud();
    void guardarSalud(Salud salud);
    void eliminarSalud(Integer id_reporte);
}
