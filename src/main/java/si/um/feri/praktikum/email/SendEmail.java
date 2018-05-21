package si.um.feri.praktikum.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    public static void posljiEmail(String prejemnik, String subjekt, String tekst){

        final String username = "zivljenje.aktivno@gmail.com";
        final String password = "timicerar123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("zivljenje.aktivno@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(prejemnik));
            message.setSubject(subjekt);
            message.setContent(tekst, "text/html; charset=UTF-8");
            Transport.send(message);

            System.out.println("Email je bil uspešno poslan!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
