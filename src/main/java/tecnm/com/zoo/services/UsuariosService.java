package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Usuarios;

@Service
public interface UsuariosService {

	List<Usuarios> buscarUsuarios();

	void guardarUsuario(Usuarios usuarios);

	void eliminarUsuario(Integer id_usuario);

	Usuarios buscarPorId(int id_usuario);

}
