package ru.iris.common;

/**
 * IRISv2 Project
 * Author: Nikolay A. Viguro
 * WWW: iris.ph-systems.ru
 * E-Mail: nv@ph-systems.ru
 * Date: 21.02.13
 * Time: 18:41
 * License: GPL v3
 */

import org.apache.qpid.AMQException;
import org.apache.qpid.client.AMQAnyDestination;
import org.apache.qpid.client.AMQConnection;
import org.jetbrains.annotations.NonNls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.net.URISyntaxException;

public class Messaging
{
    @NonNls
    private Connection connection;
    private Session session;
    @NonNls
    private Destination destination;
    private MessageConsumer messageConsumer;
    private MessageProducer messageProducer;
    private static Logger log = LoggerFactory.getLogger (Messaging.class);
    private I18N i18n = new I18N();

    public Messaging() throws JMSException, URISyntaxException, AMQException
    {
        log.info (i18n.message("msg.create.amqp.connection.and.session"));

        connection = new AMQConnection ("amqp://admin:admin@localhost/?brokerlist='tcp://localhost:5672'");
        connection.start ();

        session = connection.createSession (false, Session.AUTO_ACKNOWLEDGE);
        destination = new AMQAnyDestination ("ADDR:iris; {create: always, node: {type: topic}}");
        messageConsumer = session.createConsumer (destination);
        messageProducer = session.createProducer (destination);

        log.info (i18n.message("msg.done.init"));
    }


    public void close() throws JMSException
    {
        log.info (i18n.message("msg.disconnect.amqp.connection.session.etc"));

        messageConsumer.close ();
        messageProducer.close ();
        session.close ();
        connection.close ();
    }

    public MessageConsumer getConsumer()
    {
        return messageConsumer;
    }

    public MessageProducer getProducer()
    {
        return messageProducer;
    }

    public Session getSession()
    {
        return session;
    }

    public void simpleSendMessage(String topic, String key, String value)
    {
        try {
            @NonNls MapMessage message = session.createMapMessage();
            message.setStringProperty(key, value);
            message.setStringProperty ("qpid.subject", topic);
            messageProducer.send (message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}