package mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendEmail {

    public static void sendMail() {

        // Configurazione delle proprietà del server SMTP
        final String username = "your_email@gmail.com"; // Sostituisci con la tua email
        final String password = "your_password"; // Sostituisci con la tua password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Sostituisci con il tuo host SMTP
        props.put("mail.smtp.port", "587"); // Sostituisci con la tua porta SMTP

        // Creazione della sessione
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Creazione del messaggio
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("your_email@gmail.com")); //Sostituisci con la tua email
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("recipient_email@example.com")); //Sostituisci con l'email del destinatario
            message.setSubject("Oggetto dell'email");
            message.setText("Corpo dell'email");

            // Invio del messaggio
            Transport.send(message);

            System.out.println("Email inviata con successo");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}