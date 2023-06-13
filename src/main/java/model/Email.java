package model;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
     public static void enviaremail(ArrayList<Informacoes> pedidos) {
        // Configurações do servidor de e-mail
        String toEmail = "";
        String subject = "";
        String body = "";
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "your_email@gmail.com";
        String password = "your_password";

        // Configurações do e-mail
        
        String fromEmail = "your_email@gmail.com";
        for (Informacoes pedido : pedidos) {
            toEmail = pedido.getEmail();
            subject = "Pizzaria 3 Amigos: Pedido Sr.(a) " + pedido.getNome();
            body = "Olá, seu pedido foi realizado com sucesso.\n"
                    + "Abaixo estão as informações do seu pedido" + pedido.toStringPedido() +
                    "\n\n Você será avisado da entrega pelo telefone!" +
                    "\n\n A PIZZARIA 3 AMIGOS AGRADECE A PREFERÊNCIA";
        }
        // Configura as propriedades
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Cria uma sessão de e-mail autenticada
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your_email@gmail.com", "your_password");
            }
        });

        try {
            // Cria a mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            // Envia o e-mail
            Transport.send(message);

            System.out.println("E-mail enviado com sucesso!");
        } catch (MessagingException e) {
            System.out.println("Erro ao enviar o e-mail: " + e.getMessage());
        }
    }
}
