package eero.dogfood.eeroos;

import java.io.IOException;

public class SendMailExample {
	/**
	 * @param args
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */

	/*
	 * WebDriverManager.firefoxdriver().setup(); FirefoxDriver driver = new
	 * FirefoxDriver(); driver.get("https://dashboard.stage.e2ro.com/");
	 * 
	 * // Sender's email and password final String from = "naveen.kumar@eero.com";
	 * final String password = "adlp xzeu hcgg hlwn  "; // Recipient's email address
	 * String to = "naveenkumarng95@gmail.com"; // Set up properties for the mail
	 * server Properties properties = new Properties();
	 * properties.put("mail.smtp.auth", "true");
	 * properties.put("mail.smtp.starttls.enable", "true");
	 * properties.put("mail.smtp.host", "smtp.gmail.com");
	 * properties.put("mail.smtp.port", "25");
	 * properties.put("mail.smtp.starttls.enable", "true");
	 * properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
	 * 
	 * // Get the Session object Session session = Session.getInstance(properties,
	 * new Authenticator() {
	 * 
	 * @Override protected PasswordAuthentication getPasswordAuthentication() {
	 * return new PasswordAuthentication(from, password); } }); try { // Create a
	 * MimeMessage object Message message = new MimeMessage(session); // Set the
	 * sender and recipient addresses message.setFrom(new InternetAddress(from));
	 * message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	 * // Set the email subject and content
	 * message.setSubject("Hello, this is a test email!");
	 * message.setText("Hi Naveen."); // Send the email Transport.send(message);
	 * System.out.println("Email sent successfully!"); } catch (MessagingException
	 * e) { e.printStackTrace(); } }
	 */

	public static void main(String[] args) {

	}
}
