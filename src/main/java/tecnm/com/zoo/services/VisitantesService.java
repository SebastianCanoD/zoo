package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Visitantes;

@Service
public interface VisitantesService {

	List<Visitantes> buscarVisitantes();
    void guardarVisitante(Visitantes visitantes);
    void eliminarVisitante(Integer id_visitante);
}
