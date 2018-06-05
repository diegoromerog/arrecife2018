package co.com.sbd.registroeventos.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Eventos")
public class Evento implements Serializable {

	@Id
	@Column(name="IDEVENTO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IDEVENTO ;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Cuando")
	private String cuando;
	
	@Column(name="Donde")
	private String donde;
	
	@Column(name="Estado")
	private String estado;
	
	@OneToMany(mappedBy="evento", fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<UsuarioRegistrado> usuariosRegistrados;
	
	public Evento() {
		// TODO Auto-generated constructor stub
	}
	
	public Evento(String nombre, String cuando, String donde, String estado) {
		super();
		this.nombre = nombre;
		this.cuando = cuando;
		this.donde = donde;
		this.estado = estado;
	}

	public int getIDEVENTO() {
		return IDEVENTO;
	}

	public void setIDEVENTO(int iDEVENTO) {
		IDEVENTO = iDEVENTO;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuando() {
		return cuando;
	}

	public void setCuando(String cuando) {
		this.cuando = cuando;
	}

	public String getDonde() {
		return donde;
	}

	public void setDonde(String donde) {
		this.donde = donde;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<UsuarioRegistrado> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}

	public void setUsuariosRegistrados(Set<UsuarioRegistrado> usuariosRegistrados) {
		this.usuariosRegistrados = usuariosRegistrados;
	}


}
