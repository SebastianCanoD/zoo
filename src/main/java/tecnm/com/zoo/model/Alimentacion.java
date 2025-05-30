package tecnm.com.zoo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="alimentacion")
public class Alimentacion {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_alimentacion;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
    private String tipo_alimento;
    private String cantidad;
    private String observaciones;
    
    @ManyToOne
    @JoinColumn(name = "id_animal")
    private Animales animales;

	public Integer getId_alimentacion() {
		return id_alimentacion;
	}

	public void setId_alimentacion(Integer id_alimentacion) {
		this.id_alimentacion = id_alimentacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipo_alimento() {
		return tipo_alimento;
	}

	public void setTipo_alimento(String tipo_alimento) {
		this.tipo_alimento = tipo_alimento;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Animales getAnimales() {
		return animales;
	}

	public void setAnimales(Animales animales) {
		this.animales = animales;
	}

	@Override
	public String toString() {
		return "Alimentacion [id_alimentacion=" + id_alimentacion + ", fecha=" + fecha + ", tipo_alimento="
				+ tipo_alimento + ", cantidad=" + cantidad + ", observaciones=" + observaciones + ", animales="
				+ animales + "]";
	}

	public Alimentacion(Integer id_alimentacion, Date fecha, String tipo_alimento, String cantidad,
			String observaciones, Animales animales) {
		super();
		this.id_alimentacion = id_alimentacion;
		this.fecha = fecha;
		this.tipo_alimento = tipo_alimento;
		this.cantidad = cantidad;
		this.observaciones = observaciones;
		this.animales = animales;
	}
    
	public Alimentacion() {
		
	}
}
