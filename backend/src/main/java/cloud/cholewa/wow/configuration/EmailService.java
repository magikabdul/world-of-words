package cloud.cholewa.wow.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final AdminData admin;

    public void send(String to, String title, String content) {
        MimeMessage mail = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setReplyTo(admin.getMail());
            helper.setFrom(admin.getMail());
            helper.setSubject(title);
            helper.setText(content);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(mail);
    }
}
