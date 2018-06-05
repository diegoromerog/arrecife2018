package co.com.sbd.registroeventos.service;

import java.util.List;

import co.com.sbd.registroeventos.model.UsuarioRegistrado;

public interface IUsuarioRegistradoService {

	void save(UsuarioRegistrado usuarioRegistrado);
	
	void delete(int IDREGISTRO);
	
	void update(UsuarioRegistrado usuarioRegistrado);

	List<UsuarioRegistrado> getByEvento(int IDEVENTO);
	
	List<UsuarioRegistrado> get();
	
	UsuarioRegistrado findById(int IDUSUARIO);
	
	UsuarioRegistrado findByCorreoElectronico(String correoElectronico);
	
	UsuarioRegistrado findByEventoAndCorreoElectronico(int IdEvento, String correoElectronico);
	
}
