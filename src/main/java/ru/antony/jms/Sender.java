// http://keepjblog.blogspot.com/2015/01/jms-20-wildfly.html

package ru.antony.jms;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import java.util.logging.Logger;

@ApplicationScoped
public class Sender {
    private static final Logger LOG = Logger.getLogger(Sender.class.getName());

    @Resource(mappedName = "java:/jms/queue/test")
    private Queue queue;

    @Inject
    private JMSContext context;

    public void sendMessage(String txt) {
        LOG.info("Sending message: " + txt);
        context.createProducer().send(queue, txt);
    }
}
