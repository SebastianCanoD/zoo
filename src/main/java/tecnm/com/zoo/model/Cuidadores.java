package tecnm.com.zoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cuidadores")
public class Cuidadores {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_cuidador;
    private String nombre;
    private String telefono;
    private String correo;
    private String imagen; 
    
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Integer getId_cuidador() {
		return id_cuidador;
	}
	public void setId_cuidador(Integer id_cuidador) {
		this.id_cuidador = id_cuidador;
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
		return "Cuidadores [id_cuidador=" + id_cuidador + ", nombre=" + nombre + ", telefono=" + telefono + ", correo="
				+ correo + ", imagen=" + imagen + "]";
	}
	
	public Cuidadores(Integer id_cuidador, String nombre, String telefono, String correo, String imagen) {
		super();
		this.id_cuidador = id_cuidador;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.imagen = imagen;
	}
    
	public Cuidadores() {
		
	}
}
