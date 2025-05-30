package tecnm.com.zoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	private String nombre;
	private String username;
	private String password;
	private Boolean enabled;

	@Enumerated(EnumType.STRING)
	private Rol rol;

	public Usuarios(Integer id_usuario, String nombre, String username, String password, Rol rol, Boolean enabled) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.username = username;
		this.password = password;
		this.rol = rol;
		this.enabled = enabled;
	}

	public Usuarios() {
	}

	@Override
	public String toString() {
		return "Usuarios [id_usuario=" + id_usuario + ", nombre=" + nombre + ", username=" + username + ", password="
				+ password + ", rol=" + rol + ", enabled=" + enabled + "]";
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() { // Corregí el método: estaba "getuUsername"
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}