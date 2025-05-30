package tecnm.com.zoo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name="salud")
public class Salud {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_reporte;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "id_animal")
    private Animales animales;

    @ManyToOne
    @JoinColumn(name = "id_cuidador")
    private Cuidadores cuidadores;

	public Integer getId_reporte() {
		return id_reporte;
	}

	public void setId_reporte(Integer id_reporte) {
		this.id_reporte = id_reporte;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Animales getAnimales() {
		return animales;
	}

	public void setAnimales(Animales animales) {
		this.animales = animales;
	}

	public Cuidadores getCuidadores() {
		return cuidadores;
	}

	public void setCuidadores(Cuidadores cuidadores) {
		this.cuidadores = cuidadores;
	}

	@Override
	public String toString() {
		return "Salud [id_reporte=" + id_reporte + ", fecha=" + fecha + ", estado=" + estado + ", descripcion="
				+ descripcion + ", animales=" + animales + ", cuidadores=" + cuidadores + "]";
	}

	public Salud(Integer id_reporte, Date fecha, Estado estado, String descripcion, Animales animales,
			Cuidadores cuidadores) {
		super();
		this.id_reporte = id_reporte;
		this.fecha = fecha;
		this.estado = estado;
		this.descripcion = descripcion;
		this.animales = animales;
		this.cuidadores = cuidadores;
	}
    
	public Salud() {
		
	}
}
