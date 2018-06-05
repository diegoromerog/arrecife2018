package co.com.sbd.registroeventos.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.sbd.registroeventos.model.UsuarioRegistrado;

@Repository
@Transactional
public class UsuarioRegistradoRepository extends AbstractSession implements IUsuarioRegistradoRepository {

	@Override
	public void save(UsuarioRegistrado usuarioRegistrado) {
		getSession().persist(usuarioRegistrado);		
	}

	@Override
	public void delete(int IDREGISTRO) {
		UsuarioRegistrado usuarioRegistrado = findById(IDREGISTRO);
		if (usuarioRegistrado != null) {
			getSession().delete(usuarioRegistrado);
		}
	}

	@Override
	public void update(UsuarioRegistrado usuarioRegistrado) {
		getSession().update(usuarioRegistrado);		
	}

	@Override
	public List<UsuarioRegistrado> getByEvento(int IDEVENTO) {
		return getSession().createQuery(
				"FROM UsuarioRegistrado WHERE evento = :evento")
				.setParameter("evento", IDEVENTO)
				.list();
	}
	
	@Override
	public List<UsuarioRegistrado> get() {
		return getSession().createQuery(
				"FROM UsuarioRegistrado")
				.list();
	}

	@Override
	public UsuarioRegistrado findById(int IDUSUARIO) {
		return (UsuarioRegistrado) getSession().get(UsuarioRegistrado.class, IDUSUARIO);
	}

	@Override
	public UsuarioRegistrado findByCorreoElectronico(String correoElectronico) {
		return (UsuarioRegistrado) getSession().createQuery(
				"FROM UsuarioRegistrado WHERE correoElectronico = :correoElectronico")
				.setParameter("correoElectronico", correoElectronico);
	}

	@Override
	public UsuarioRegistrado findByEventoAndCorreoElectronico(int IdEvento, String correoElectronico) {
		return (UsuarioRegistrado) getSession().createQuery(
				"FROM UsuarioRegistrado AS UR WHERE UR.evento.IDEVENTO = :evento AND UR.correoElectronico = :correoElectronico")
				.setParameter("evento", IdEvento)
				.setParameter("correoElectronico", correoElectronico);
	}
	
}
