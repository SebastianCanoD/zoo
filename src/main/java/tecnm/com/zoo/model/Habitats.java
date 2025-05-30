package tecnm.com.zoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="habitats")
public class Habitats {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_habitat;
    private String nombre;
    private String continente;
    private String imagen; 
    
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Integer getId_habitat() {
		return id_habitat;
	}
	public void setId_habitat(Integer id_habitat) {
		this.id_habitat = id_habitat;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
    
	public Habitats(Integer id_habitat, String nombre, String continente, String imagen) {
		super();
		this.id_habitat = id_habitat;
		this.nombre = nombre;
		this.continente = continente;
		this.imagen = imagen;
	}
	
	@Override
	public String toString() {
		return "Habitats [id_habitat=" + id_habitat + ", nombre=" + nombre + ", continente=" + continente + ", imagen="
				+ imagen + "]";
	}
	
	public Habitats() {
		
	}
}
