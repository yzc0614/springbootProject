package com.chinasoft;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("小辣鸡");
        mailMessage.setText("hello world");
        mailMessage.setTo("");
        mailMessage.setFrom("913864980@qq.xom");
        javaMailSender.send(mailMessage);
    }

    @Test
    void contextLoads1() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
//        正文
        helper.setSubject("小拉吉");
        helper.setText("<p style='color: red;'>hello world</P>",true);
        //附件
        helper.addAttachment("1.jpg",new File(""));

        helper.setTo("");
        helper.setFrom("");
        javaMailSender.send(mimeMessage);
    }

}
