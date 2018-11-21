package edu.mum.cs425.project.eshoppers.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;

//@RestController
public class EmailController {

    // @RequestMapping(value = "/sendemail")
    public static String sendEmail(String email) {
        try{
            sendmail(email);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Email sent successfully");

        return "Email sent successfully";
    }


    private static void sendmail(String email) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("erishoppers@gmail.com", "eshoppers@mum");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("dawitaraya7@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("da16ni19@gmail.com"));
        // msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        msg.setSubject("E-Shoppers Order Confirmation");
        msg.setContent("E-Shoppers email", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        // messageBodyPart.setContent("Tutorials point email", "text/html");
        messageBodyPart.setContent("Hi Daniel your order will arrive: " + LocalDate.now().plusDays(2), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        //MimeBodyPart attachPart = new MimeBodyPart();

        // attachPart.attachFile("/var/tmp/image19.png");
        // multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }

}