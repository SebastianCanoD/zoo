package tecnm.com.zoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "visitantes")
public class Visitantes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_visitante;
	private String nombre;
	private String telefono;
	private String correo;

	public Integer getId_visitante() {
		return id_visitante;
	}

	public void setId_visitante(Integer id_visitante) {
		this.id_visitante = id_visitante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Visitantes [id_visitante=" + id_visitante + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", correo=" + correo + "]";
	}

	public Visitantes(Integer id_visitante, String nombre, String telefono, String correo) {
		super();
		this.id_visitante = id_visitante;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}

	public Visitantes() {

	}
}
