package co.com.sbd.registroeventos.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import co.com.sbd.registroeventos.model.Evento;
import co.com.sbd.registroeventos.service.IEventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/v1")
public class EventoController {

	@Autowired
	IEventoService _eventoService;
	
	// GET - Traer eventos activos
	@RequestMapping(value="/eventos", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<Evento>> getAll(){
		List<Evento> eventos = new ArrayList<>();
		
		eventos = _eventoService.getActivos();
		if (eventos.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Evento>>(eventos, HttpStatus.OK);
	}
	
	// GET - Traer un evento por ID
	@RequestMapping(value="/eventos/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<Evento> getByID(@PathVariable("id") int idEvento){		
		Evento evento = _eventoService.findById(idEvento);
		
		if (evento == null){
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		else{			
			return new ResponseEntity<Evento>(evento, HttpStatus.OK);
		}		
	}
	
	// POST - Crear un Evento
	@RequestMapping(value="/eventos", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<?> add(@RequestBody Evento evento, UriComponentsBuilder uriComponentBuilder){
		
		// Verifica que al menos venga un nombre en el objeto
		if(evento.getNombre().equals(null) || evento.getNombre().isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		// Guarda la información del objeto
		_eventoService.save(evento);
		
		// Arma el string de respuesta
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentBuilder.path("/v1/eventos/{1}")
				.buildAndExpand(1)
				.toUri()
				);
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	// DELETE
	@RequestMapping(value="/eventos/{id}", method=RequestMethod.PATCH)
	public ResponseEntity<?> delete(@PathVariable("id") int idEvento){
		
		Evento evento = _eventoService.findById(idEvento);
		
		if (evento == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Evento>(HttpStatus.OK);		
	}	
	
}
