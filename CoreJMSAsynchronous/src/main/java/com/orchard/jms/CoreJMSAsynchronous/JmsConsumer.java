package com.orchard.jms.CoreJMSAsynchronous;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.activemq.ActiveMQConnectionFactory;

@Path("/consumer")
public class JmsConsumer {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String consumner() {
		Connection connection = null;
		Session session = null;
		MessageConsumer consumer = null;
		String text = "";
		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://G1C2ML15505:61616");
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("JMS_TESTQ");
			consumer = session.createConsumer(destination);
			Message message = consumer.receive(1000);
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				text = textMessage.getText();
			}
			consumer.close();
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {

		}
		return text;
	}
}
