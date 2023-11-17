package com.chagiya.services.implementors;

import io.github.cdimascio.dotenv.Dotenv;
import com.chagiya.services.interfaces.EmailService;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailServiceImpl implements EmailService {
    private final String USERNAME;
    private final String PASSWORD;
    private final String TO;

    public EmailServiceImpl() {
        Dotenv dotenv = Dotenv.load();
        USERNAME = dotenv.get("EMAIL_USERNAME");
        PASSWORD = dotenv.get("EMAIL_PASSWORD");
        TO = dotenv.get("EMAIL_TO");
    }

    public void sendEmail(String from, String subject, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        props.put("mail.smtp.port", "2525");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Email sent successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

