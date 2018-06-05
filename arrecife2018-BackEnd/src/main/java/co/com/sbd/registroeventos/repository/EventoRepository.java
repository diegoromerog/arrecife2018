package co.com.sbd.registroeventos.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.sbd.registroeventos.model.Evento;

@Repository
@Transactional
public class EventoRepository extends AbstractSession implements IEventoRepository {

	@Override
	public void save(Evento evento) {
		getSession().persist(evento);
	}

	@Override
	public void delete(int IDEVENTO) {
		Evento evento = findById(IDEVENTO);
		if (evento != null) {
			getSession().delete(evento);
		}
	}

	@Override
	public void update(Evento evento) {
		getSession().update(evento);
	}

	@Override
	public List<Evento> getAll() {
		return getSession().createQuery("FROM Evento").list();
	}

	@Override
	public List<Evento> getActivos() {
		return getSession().createQuery(
				"FROM Evento WHERE Estado = :estado")
				.setParameter("estado", 1)
				.list();
	}

	@Override
	public Evento findById(int IDEVENTO) {
		return (Evento)getSession().get(Evento.class, IDEVENTO);
	}

}
