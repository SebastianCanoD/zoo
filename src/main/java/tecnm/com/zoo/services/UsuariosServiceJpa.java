package tecnm.com.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import tecnm.com.zoo.model.Usuarios;
import tecnm.com.zoo.repository.UsuariosRepository;

@Service
@Primary
public class UsuariosServiceJpa implements UsuariosService {

	@Autowired
	private UsuariosRepository repoUsuarios;

	@Override
	public List<Usuarios> buscarUsuarios() {
		// TODO Auto-generated method stub
		return repoUsuarios.findAll();
	}

	@Override
	public void guardarUsuario(Usuarios usuarios) {
		repoUsuarios.save(usuarios);

	}

	@Override
	public void eliminarUsuario(Integer id_usuario) {
		repoUsuarios.deleteById(id_usuario);

	}

	@Override
	public Usuarios buscarPorId(int id_usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
