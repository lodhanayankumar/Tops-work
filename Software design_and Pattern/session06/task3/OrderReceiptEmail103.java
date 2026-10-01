package session06;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class OrderReceiptEmail103 {

    public static void main(String[] args) {

        final String senderEmail = "yourgmail@gmail.com";
        final String appPassword = "your-app-password";
        final String receiverEmail = "yourgmail@gmail.com";

        // PDF file location
        String pdfFilePath = "C:/Users/PC/Desktop/Order Receipt.pdf";

        // Gmail SMTP settings
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create mail session
        Session session = Session.getInstance(
                properties,
                new Authenticator() {

                    @Override
                    protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail,appPassword);
                    }
                }
        );

        try {
            // Create email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));

            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse(receiverEmail));

            // Email subject
            message.setSubject("Foodies App - Order Receipt");

            // Create email body
            MimeBodyPart messageBodyPart = new MimeBodyPart();

            String htmlMessage =
                    "<html>" +
                    "<body>" +
                    "<h2 style='background-color:orange;" +
                    "color:white;padding:15px;'>" +
                    "Foodies App" +
                    "</h2>" +
                    "<p>Hello <b>Nayan</b>,</p>" +
                    "<p>" +
                    "Thank you for your order." +
                    "</p>" +
                    "<p>" +
                    "Please find your order receipt " +
                    "attached with this email." +
                    "</p>" +
                    "<p>Thank you for using Foodies App!</p>" +
                    "</body>" +
                    "</html>";
            // Set HTML content
            messageBodyPart.setContent(htmlMessage,"text/html");
            // Create attachment part
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(pdfFilePath);
            // Give attachment a proper name
            attachmentPart.setFileName("Order Receipt.pdf");
            // Combine body and attachment
            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);
            // Set complete email content
            message.setContent(multipart);
            // Send email
            Transport.send(message);
            System.out.println("Email sent successfully!");
            System.out.println("PDF attachment added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}