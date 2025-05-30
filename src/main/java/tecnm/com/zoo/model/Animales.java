package tecnm.com.zoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "animales")
public class Animales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_animal;
	private String nombre;

	@Enumerated(EnumType.STRING)
	private Dieta dieta;
	private String peso;

	private String imagen;

	@ManyToOne
	@JoinColumn(name = "id_especie")
	private Especies especies;

	@ManyToOne
	@JoinColumn(name = "id_habitat")
	private Habitats habitats;

	@ManyToOne
	@JoinColumn(name = "id_cuidador")
	private Cuidadores cuidadores;

	public Integer getId_animal() {
		return id_animal;
	}

	public void setId_animal(Integer id_animal) {
		this.id_animal = id_animal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Especies getEspecies() {
		return especies;
	}

	public void setEspecies(Especies especies) {
		this.especies = especies;
	}

	public Habitats getHabitats() {
		return habitats;
	}

	public void setHabitats(Habitats habitats) {
		this.habitats = habitats;
	}

	public Cuidadores getCuidadores() {
		return cuidadores;
	}

	public void setCuidadores(Cuidadores cuidadores) {
		this.cuidadores = cuidadores;
	}

	@Override
	public String toString() {
		return "Animales [id_animal=" + id_animal + ", nombre=" + nombre + ", dieta=" + dieta + ", peso=" + peso
				+ ", imagen=" + imagen + ", especies=" + especies + ", habitats=" + habitats + ", cuidadores="
				+ cuidadores + "]";
	}

	public Animales(Integer id_animal, String nombre, Dieta dieta, String peso, String imagen, Especies especies,
			Habitats habitats, Cuidadores cuidadores) {
		super();
		this.id_animal = id_animal;
		this.nombre = nombre;
		this.dieta = dieta;
		this.peso = peso;
		this.imagen = imagen;
		this.especies = especies;
		this.habitats = habitats;
		this.cuidadores = cuidadores;
	}

	public Animales() {

	}
}
