package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class exampleTest{

    static WebDriver driver;


    @BeforeEach
    public void Setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mertcan.yuksekkaya\\Desktop\\JavaSeleniumExample\\drivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void Test() {


        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);

        // Sayfaya yölendiriliyor ve sayfa linki kontrol ediliyor.
        driver.get("http://testkalite.com/");


    }


    @AfterEach
    public void TearDown() {

        // Driver kapanıyor.
        driver.quit();

        // E-Mail Bilgileri Tanımlanıyor.
        String from = "mertcanyuksekkaya@hotmail.com";
        String to = "mertcanyuksekkaya@hotmail.com";
        String subject = "Selenium Test Result";
        String bodyText = "Test Sonucu ekte gönderilmiştir. Lütfen gönderilen dosyayı indirin ve herhangi bir tarayıcıda açın.";

        // Attach Edilecek Dosyanın Dizini Tanımlanıyor.
        String attachmentName = "C:\\Users\\mertcan.yuksekkaya\\Desktop\\JavaSeleniumExample\\src\\test\\java\\rapor.xlsx";

        // SMTP Bilgileri Tanımlanıyor.
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props);

        try {
            InternetAddress fromAddress = new InternetAddress(from);
            InternetAddress toAddress = new InternetAddress(to);

            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(fromAddress);
            msg.setRecipient(Message.RecipientType.TO, toAddress);
            msg.setSubject(subject);
            msg.setSentDate(new Date());

            MimeBodyPart messagePart = new MimeBodyPart();
            messagePart.setText(bodyText);

            FileDataSource fileDataSource = new FileDataSource(attachmentName);

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.setDataHandler(new DataHandler(fileDataSource));
            attachmentPart.setFileName(fileDataSource.getName());

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messagePart);
            multipart.addBodyPart(attachmentPart);

            msg.setContent(multipart);
            Transport.send(msg, "mertcanyuksekkaya@hotmail.com", "*3115mertcan899*");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}