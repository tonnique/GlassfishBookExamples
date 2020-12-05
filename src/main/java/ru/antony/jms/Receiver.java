package ru.antony.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;


@MessageDriven(name = "Receiver", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queue/test"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class Receiver implements MessageListener {
    private static final Logger LOG = Logger.getLogger(Receiver.class.getName());

    public void onMessage(Message rcvMessage) {
        try {
            LOG.info("Message : " + rcvMessage.getBody(String.class));
        } catch (JMSException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
