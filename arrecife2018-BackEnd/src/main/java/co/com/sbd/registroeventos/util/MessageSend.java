package co.com.sbd.registroeventos.util;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MessageSend {

    private String asunto;
    private String mensaje;
    private String remitente;
    private String contrasena;
    private InternetAddress[] destinatarios;
    private ArrayList<String> correos;
    
    public static void main(String[] args) throws AddressException {
/*        
  		String asunto = "Inscripción a \"Administración y Monitoreo Remoto de Plataformas de Bases de Datos y Capa Media\"";
        ArrayList<String> destinatarios = new ArrayList<String>();
        destinatarios.add("dromero@outlook.com");
        String mensaje = ""+
        		"Estimado(a)  Diego Romero,<br/><br/>" +
        		"Gracias por su interés en el  Webinar <span style=\"font-weight: bold;\">Administración y Monitoreo Remoto de Plataformas de Bases de Datos y Capa Media</span><br/><br/>" +
        		"Su inscripción será evaluada por nuestro equipo. Si es aprobada, usted recibirá un e-mail con la confirmación de su participación y otros detalles del evento<br/><br/>" +
        		"<span style=\"font-weight: bold;\">Importante: Este mensaje no confirma su inscripción. Por favor espere por el correo de confirmación.</span><br/><br/>" +
        		"Atentamente,<br/><br/>" +
        		"Departamento de Mercadeo SBD";
        MessageSend ms = new MessageSend(asunto, mensaje, destinatarios);
        ms.send();
*/    
    }
    
    public MessageSend(String asunto, String mensaje, ArrayList<String> email) throws AddressException {
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.remitente = "arrecife@sbd.com.co";
        this.contrasena = "Sbd2017**";
        this.correos = email;
        this.destinatarios = new InternetAddress[email.size()];
        for (int i = 0; i < email.size(); i++) {
            this.destinatarios[i] = new InternetAddress(email.get(i));
        }
    }
    
    public void send(){
        Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "mail.sbd.com.co");
	props.put("mail.smtp.port", "25");
                
	Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(remitente, contrasena);
                }
            }
        );
        
	try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(remitente));
        message.setRecipients(Message.RecipientType.TO, destinatarios);
        message.setSubject(asunto);
        message.setContent(mensaje, "text/html;charset=utf-8");
        Transport.send(message);
        System.out.println(toString());
		} catch (MessagingException e) {
		        throw new RuntimeException(e);
		}   
    }
    
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public InternetAddress[] getDestinatario() {
        return destinatarios;
    }

    public void setDestinatario(InternetAddress[] destinatario) {
        this.destinatarios = destinatario;
    }

    @Override
    public String toString() {
        return "Mensaje enviado:" + "\nAsunto: " + asunto+ "\nRemitente: " + remitente + "\nDestinatarios:" + correos.toString() + "\nMensaje: " + mensaje ;
    }
	
}
