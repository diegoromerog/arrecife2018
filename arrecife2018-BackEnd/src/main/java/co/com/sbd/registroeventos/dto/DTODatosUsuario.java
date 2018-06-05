package co.com.sbd.registroeventos.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class DTODatosUsuario implements Serializable {

	private int evento;

	private String correoElectronico;
	
	private String nombres;
	
	private String telefonoCelular;
	
	private String telefonoFijo;

	private String empresa;

	private String cargo;

	private String basesDeDatos;

	private String servidorAplicaciones;

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
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

	
}
