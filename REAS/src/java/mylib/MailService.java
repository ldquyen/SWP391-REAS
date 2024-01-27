/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author sny12
 */
public class MailService {
    
    // config your mail to send for users.
    public final static String sendFrom = "thanhnguyenk162912@gmail.com";
    // cai password la do google cap cho nhung ung dung ngoai.
    public final static String password = "qpchendxnjykabor";

    public static boolean sendMail(String sendTo, String Title, String Object) {
        // Properties : Khai bao thuoc tinh.
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");  // STMP - HOST      
        props.put("mail.smtp.port", "587"); // TLS - Google: 587 / SSL: 465
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        //Create Authenticator - Tu dong login vao mail
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendFrom, password);
            };
        };
        
        // get session cua javaxmail 
        Session session = Session.getInstance(props, auth);
        // Sendmail.
        // compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sendFrom));// change accordingly
            //Message.RecipientType.TO : 1 nguoi 
            // BCC - nhieu nguoi             
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
            message.setSubject(Title);
            // In this case if you just want sent some text to user use setText props.
            message.setText(Object);
            //Otherwise your content of mail is html,etc,... you must change to use setContext props.
            // send message
            Transport.send(message);
            System.out.println("Message sent successfully"); 
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
