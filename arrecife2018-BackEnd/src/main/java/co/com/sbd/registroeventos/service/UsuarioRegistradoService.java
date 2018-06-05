package co.com.sbd.registroeventos.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.sbd.registroeventos.model.UsuarioRegistrado;
import co.com.sbd.registroeventos.repository.IUsuarioRegistradoRepository;
import co.com.sbd.registroeventos.util.MessageSend;

@Service("usuarioRegistradoService")
@Transactional
public class UsuarioRegistradoService implements IUsuarioRegistradoService {

	@Autowired
	private IUsuarioRegistradoRepository _IUsuarioRegistrado;
	
	@Override
	public void save(UsuarioRegistrado usuarioRegistrado) {
		try {
			_IUsuarioRegistrado.save(usuarioRegistrado);
			enviarCorreoConfirmacion(usuarioRegistrado.getCorreoElectronico(), usuarioRegistrado.getNombres(), "Administración y Monitoreo Remoto de Plataformas de Bases de Datos y Capa Media");
		} catch (AddressException e) {
			e.printStackTrace();
		}
	}

    private void enviarCorreoConfirmacion(String Correo, String Nombre, String Evento) throws AddressException {
        String asunto = "Inscripción a \"" + Evento + "\"";
        ArrayList<String> destinatarios = new ArrayList<String>();
        destinatarios.add(Correo);
        String mensaje = ""+
        		"Estimado(a)  " + Nombre + ",<br/><br/>" +
        		"Gracias por su interés en el  Webinar <span style=\"font-weight: bold;\">" + Evento + "</span><br/><br/>" +
        		"Su inscripción será evaluada por nuestro equipo. Si es aprobada, usted recibirá un e-mail con la confirmación de su participación y otros detalles del evento<br/><br/>" +
        		"<span style=\"font-weight: bold;\">Importante: Este mensaje no confirma su inscripción. Por favor espere por el correo de confirmación.</span><br/><br/>" +
        		"Atentamente,<br/><br/>" +
        		"Departamento de Mercadeo SBD";
        MessageSend ms = new MessageSend(asunto, mensaje, destinatarios);
        ms.send();
    }
	
	
	@Override
	public void delete(int IDREGISTRO) {
		_IUsuarioRegistrado.delete(IDREGISTRO);
	}

	@Override
	public void update(UsuarioRegistrado usuarioRegistrado) {
		_IUsuarioRegistrado.update(usuarioRegistrado);
	}
	
	@Override
	public List<UsuarioRegistrado> get() {
		return _IUsuarioRegistrado.get();
	}

	@Override
	public List<UsuarioRegistrado> getByEvento(int IDEVENTO) {
		return _IUsuarioRegistrado.getByEvento(IDEVENTO);
	}

	@Override
	public UsuarioRegistrado findById(int IDUSUARIO) {
		return _IUsuarioRegistrado.findById(IDUSUARIO);
	}

	@Override
	public UsuarioRegistrado findByCorreoElectronico(String correoElectronico) {
		return _IUsuarioRegistrado.findByCorreoElectronico(correoElectronico);
	}

	@Override
	public UsuarioRegistrado findByEventoAndCorreoElectronico(int IdEvento, String correoElectronico) {
		return _IUsuarioRegistrado.findByEventoAndCorreoElectronico(IdEvento, correoElectronico);
	}

}
