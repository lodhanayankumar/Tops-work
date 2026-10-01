package session06;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class GmailSMTPTest {

    public static void main(String[] args) {

        final String senderEmail = "nayankumar@gmail.com";
        final String appPassword = "mmm12@120";
        final String receiverEmail = "mahesh122@gmail.com";

        // SMTP settings
        Properties properties = new Properties();

        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");

        // Create mail session
        Session session = Session.getInstance(
                properties,
                new Authenticator() {

                    @Override
                    protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, appPassword);
                    }
                }
        );

        try {
            // Create email
            Message message = new MimeMessage(session);

            // Sender
            message.setFrom(new InternetAddress(senderEmail));

            // Receiver
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiverEmail));
            // Subject
            message.setSubject("Test SMTP Setup");
            // Email body
            message.setText(
                    "Hello,\n\n" +
                    "This is a simple test email sent " +
                    "using Gmail SMTP from a Java application.\n\n");
            Transport.send(message);

            System.out.println("email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}