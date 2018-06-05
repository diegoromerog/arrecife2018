package co.com.sbd.registroeventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.sbd.registroeventos.model.Evento;
import co.com.sbd.registroeventos.repository.IEventoRepository;

@Service("eventoService")
@Transactional
public class EventoService implements IEventoService {

	@Autowired
	private IEventoRepository _IEvento;
	
	@Override
	public void save(Evento evento) {
		_IEvento.save(evento);
	}

	@Override
	public void delete(int IDEVENTO) {
		_IEvento.delete(IDEVENTO);
	}

	@Override
	public void update(Evento evento) {
		_IEvento.update(evento);
	}

	@Override
	public List<Evento> getAll() {
		return _IEvento.getAll();
	}

	@Override
	public List<Evento> getActivos() {
		return _IEvento.getActivos();
	}

	@Override
	public Evento findById(int IDEVENTO) {
		return _IEvento.findById(IDEVENTO);
	}

}
