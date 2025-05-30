package tecnm.com.zoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="especies")
public class Especies {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_especie;
    private String nombre_cientifico;
    private String nombre_comun;
    private String imagen; 
    
    public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Enumerated(EnumType.STRING)
    private Clase clase;

	public Integer getId_especie() {
		return id_especie;
	}

	public void setId_especie(Integer id_especie) {
		this.id_especie = id_especie;
	}

	public String getNombre_cientifico() {
		return nombre_cientifico;
	}

	public void setNombre_cientifico(String nombre_cientifico) {
		this.nombre_cientifico = nombre_cientifico;
	}

	public String getNombre_comun() {
		return nombre_comun;
	}

	public void setNombre_comun(String nombre_comun) {
		this.nombre_comun = nombre_comun;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	@Override
	public String toString() {
		return "Especies [id_especie=" + id_especie + ", nombre_cientifico=" + nombre_cientifico + ", nombre_comun="
				+ nombre_comun + ", imagen=" + imagen + ", clase=" + clase + "]";
	}
    
	public Especies(Integer id_especie, String nombre_cientifico, String nombre_comun, String imagen, Clase clase) {
		super();
		this.id_especie = id_especie;
		this.nombre_cientifico = nombre_cientifico;
		this.nombre_comun = nombre_comun;
		this.imagen = imagen;
		this.clase = clase;
	}

	public Especies() {
		
	}
}
