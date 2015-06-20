package coza.opencollab.backbone.message.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.inject.Singleton;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import coza.opencollab.backbone.message.MessageTemplate;
import coza.opencollab.backbone.message.PdfDocument;
import coza.opencollab.backbone.message.service.MessageService;
import coza.opencollab.backbone.qualifiers.MapService;

@MapService
@Singleton
public class MessageServiceMapImpl implements MessageService {

    @Override
    public MessageTemplate getMessageTemplate(String templateId) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void insertMessageTemplate(MessageTemplate template) {
	// TODO Auto-generated method stub

    }

    @Override
    public void updateMessageTemplate(MessageTemplate template) {
	// TODO Auto-generated method stub

    }

    @Override
    public void deleteMessageTemplate(String templateId) {
	// TODO Auto-generated method stub

    }

    @Override
    public void sendMessage(String templateId, Map<String, String> parameters) {
	Session session = getMailSession();

	String[] cc = { "cc" };
	String[] bcc = { "bcc" };

	try {
	    Message mail = createMail("from", cc, bcc, "replyTo", session);

	    // Set message contents
	    mail.setSubject("subject");
	    mail.setSentDate(new Date());

	    Multipart mp = new MimeMultipart();
	    // create and fill the first message part
	    MimeBodyPart msgPart = new MimeBodyPart();
	    // msgPart.setText(message);
	    // set message as html
	    msgPart.setContent("message", "text/html");
	    mp.addBodyPart(msgPart);
	    List<PdfDocument> attachments = new ArrayList<PdfDocument>();
	    for (PdfDocument document : attachments) {
		// create the next message part(s)
		MimeBodyPart attachPart = new MimeBodyPart();
		// attach the next file to the message
		DataSource ds = new ByteArrayDataSource(document.getBytes(), "application/pdf");
		attachPart.setDataHandler(new DataHandler(ds));
		attachPart.setFileName(document.getFileName());
		// Add its parts to it
		mp.addBodyPart(attachPart);
		// add the Multipart to the message
	    }
	    mail.setContent(mp);

	    // Send message
	    Transport.send(mail);
	} catch (AddressException ae) {
	    // TODO Auto-generated catch block
	    ae.printStackTrace();
	} catch (MessagingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    private Session getMailSession() {
	// create some properties and get the default Session
	Properties props = new Properties();
	props.put("mail.smtp.host", "host");
	props.put("mail.smtp.port", "port");
	props.put("mail.smtp.auth", "auth");
	props.put("mail.smtp.starttls.enable", "true"/* getSmtpStartTls() */);
	Session session = Session.getDefaultInstance(props, null);
	return session;
    }

    private Message createMail(String from, String[] cc, String[] bcc, String replyTo, Session session)
	    throws MessagingException, AddressException {
	// Create Message
	Message mail = new MimeMessage(session);
	mail.setFrom(new InternetAddress(from));
	mail.setReplyTo(new Address[] { new InternetAddress(replyTo) });
	add(mail, Message.RecipientType.CC, cc);
	add(mail, Message.RecipientType.BCC, bcc);
	return mail;
    }

    private static InternetAddress[] add(Message mail, RecipientType type, String[] addresses)
	    throws MessagingException {
	if (addresses == null)
	    return null;
	InternetAddress[] toInetList = new InternetAddress[addresses.length];
	for (int i = 0; i < addresses.length; i++) {
	    toInetList[i] = new InternetAddress(addresses[i]);
	}
	mail.setRecipients(type, toInetList);
	return toInetList;
    }

}
