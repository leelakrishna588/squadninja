package com.stackroute.email.service;
import com.stackroute.email.dto.MailDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
//indicates it is a service layer
@Service
public class NotificationService
{
    //It enables to send mails
    public JavaMailSender javaMailSender;
//AMQP (Advanced Message Queuing Protocol) is the protocol used by RabbitMQ for messaging.
    private RabbitTemplate amqpTemplate;

    public NotificationService()
    {

    }
    @Autowired
    public NotificationService(JavaMailSender javaMailSender, RabbitTemplate amqpTemplate) {
        this.javaMailSender = javaMailSender;
        this.amqpTemplate = amqpTemplate;
    }
    //performing rabbitListener
    @RabbitListener(queues = "${email.rabbitmq.queue}")
   public void notificationSender(MailDto mailDto)throws MailException {
       System.out.println("Recieved Message From RabbitMQ: " + mailDto);
       //send mail The class having to,from,cc,subject,text
       SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
       //to mail id getting from rabbit consume
       simpleMailMessage.setTo(mailDto.getTo());
       simpleMailMessage.setFrom("squadninjasr@gmail.com");
       //consuming from rabbitMq email queue
       simpleMailMessage.setSubject(mailDto.getSubject());
       //consuming from rabbitMq email queue
       simpleMailMessage.setText(mailDto.getBody());
       //sending mail
       javaMailSender.send(simpleMailMessage);
    }
}
