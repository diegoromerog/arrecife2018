package co.com.sbd.registroeventos.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "UsuariosRegistrados")
public class UsuarioRegistrado implements Serializable {

	@Id
	@Column(name="IDUSUARIO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IDUSUARIO ;

	@JsonIgnore
	@ManyToOne(optional=true)
	@JoinColumn(name="Evento")
	private Evento evento;

	@Column(name="CorreoElectronico")
	private String correoElectronico;
	
	@Column(name="Nombres")
	private String nombres;
	
	@Column(name="TelefonoCelular")
	private String telefonoCelular;
	
	@Column(name="TelefonoFijo")
	private String telefonoFijo;

	@Column(name="Empresa")
	private String empresa;

	@Column(name="Cargo")
	private String cargo;

	@Column(name="BasesDeDatos")
	private String basesDeDatos;

	@Column(name="ServidorAplicaciones")
	private String servidorAplicaciones;

	@Column(name="Estado")
	private String estado;

	@Column(name="ComentariosEstado")
	private String comentariosEstado;

	public UsuarioRegistrado() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioRegistrado(Evento evento, String nombres, String telefonoCelular, String telefonoFijo,
			String empresa, String cargo, String basesDeDatos, String servidorAplicaciones, String estado,
			String comentariosEstado) {
		super();
		this.evento = evento;
		this.nombres = nombres;
		this.telefonoCelular = telefonoCelular;
		this.telefonoFijo = telefonoFijo;
		this.empresa = empresa;
		this.cargo = cargo;
		this.basesDeDatos = basesDeDatos;
		this.servidorAplicaciones = servidorAplicaciones;
		this.estado = estado;
		this.comentariosEstado = comentariosEstado;
	}

	public int getIDUSUARIO() {
		return IDUSUARIO;
	}

	public void setIDUSUARIO(int iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getBasesDeDatos() {
		return basesDeDatos;
	}

	public void setBasesDeDatos(String basesDeDatos) {
		this.basesDeDatos = basesDeDatos;
	}

	public String getServidorAplicaciones() {
		return servidorAplicaciones;
	}

	public void setServidorAplicaciones(String servidorAplicaciones) {
		this.servidorAplicaciones = servidorAplicaciones;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComentariosEstado() {
		return comentariosEstado;
	}

	public void setComentariosEstado(String comentariosEstado) {
		this.comentariosEstado = comentariosEstado;
	}

}
