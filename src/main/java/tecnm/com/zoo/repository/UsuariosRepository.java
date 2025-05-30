package tecnm.com.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tecnm.com.zoo.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
	Usuarios findByUsername(String username);
}
