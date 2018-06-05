package co.com.sbd.registroeventos.service;

import java.util.List;

import co.com.sbd.registroeventos.model.Evento;

public interface IEventoService {

	void save(Evento evento);
	
	void delete(int IDEVENTO);
	
	void update(Evento evento);

	List<Evento> getAll();
	
	List<Evento> getActivos();
	
	Evento findById(int IDEVENTO);
	
}
