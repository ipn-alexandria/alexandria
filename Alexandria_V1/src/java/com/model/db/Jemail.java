package com.model.db;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Jemail {
    
    public int enviarEmail(String destino, String contenido) {
        //int estado = 0;
        String dest = destino;
        String cont = contenido;
                
        Properties properties = new Properties();
        String password;
        Session session;

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.mail.sender", "alexandria.escom@gmail.com");
        properties.put("mail.smtp.user", "alexandria.escom@gmail.com");
        properties.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(properties);
        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(dest));
            message.setSubject("Notificación de Alexandria");
            message.setText(cont);
            Transport t = session.getTransport("smtp");
            t.connect((String) properties.get("mail.smtp.user"), "alexandria2");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            return 1;
        } catch (MessagingException me) {
            System.out.println(me);
            System.out.println("\nNo se pudo  enviar el correo:\n");
            return 0;
        }
        
        
    }
    
    public static void main(String[] args) {
        Jemail test = new Jemail();
        String d = "mike30.mdo.90@gmail.com";
        String c = "Esto es una prueba de javamail";
        
        test.enviarEmail(d, c);
    }
	
    
}
