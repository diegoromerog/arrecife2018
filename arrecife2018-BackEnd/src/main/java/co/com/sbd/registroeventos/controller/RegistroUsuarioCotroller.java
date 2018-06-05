package co.com.sbd.registroeventos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import co.com.sbd.registroeventos.dto.DTODatosUsuario;
import co.com.sbd.registroeventos.model.Evento;
import co.com.sbd.registroeventos.model.UsuarioRegistrado;
import co.com.sbd.registroeventos.service.IUsuarioRegistradoService;

@CrossOrigin
@Controller
@RequestMapping("/v1")
public class RegistroUsuarioCotroller {

	@Autowired
	IUsuarioRegistradoService _usuarioRegistradoService;	
	
	// GET
	@RequestMapping(value="/registrousuarios", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<UsuarioRegistrado>> getUsuariosEvento(){
		List<UsuarioRegistrado> usuariosRegistrados = new ArrayList<>();

		usuariosRegistrados = _usuarioRegistradoService.get();
		if (usuariosRegistrados.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UsuarioRegistrado>>(usuariosRegistrados, HttpStatus.OK);
	}
	
	@RequestMapping(value="/registrousuarios", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<?> createUsuarioEvento(@RequestBody DTODatosUsuario datosUsuario, UriComponentsBuilder uriComponentBuilder){
		
		// Guarda la información del usuario
		Evento evento = new Evento();
		evento.setIDEVENTO(datosUsuario.getEvento());

		UsuarioRegistrado usuarioRegistrado = new UsuarioRegistrado();
		usuarioRegistrado.setEvento(evento);
		usuarioRegistrado.setNombres(datosUsuario.getNombres());
		usuarioRegistrado.setTelefonoCelular(datosUsuario.getTelefonoCelular());
		usuarioRegistrado.setTelefonoFijo(datosUsuario.getTelefonoFijo());
		usuarioRegistrado.setEmpresa(datosUsuario.getEmpresa());
		usuarioRegistrado.setCargo(datosUsuario.getCargo());
		usuarioRegistrado.setBasesDeDatos(datosUsuario.getBasesDeDatos());
		usuarioRegistrado.setServidorAplicaciones(datosUsuario.getServidorAplicaciones());
		usuarioRegistrado.setCorreoElectronico(datosUsuario.getCorreoElectronico());
		usuarioRegistrado.setEstado("R");
		usuarioRegistrado.setComentariosEstado("");
		_usuarioRegistradoService.save(usuarioRegistrado);
		
		// Arma el string de respuesta
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentBuilder.path("/v1/registrousuarios/{1}")
				.buildAndExpand(usuarioRegistrado.getIDUSUARIO())
				.toUri()
				);
		return new ResponseEntity<String>(headers, HttpStatus.OK);
	}
	
}
