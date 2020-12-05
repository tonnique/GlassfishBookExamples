package ru.antony.jms;


import javax.annotation.Resource;
import javax.jms.*;

public class MessageSenderOld {

    @Resource(mappedName = "java:/jms/ConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource (mappedName = "java:/jms/queue/test")
    private static Queue queue;

    public void produceMessages() {
        MessageProducer messageProducer;
        TextMessage textMessage;

        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(queue);
            textMessage = session.createTextMessage();
            textMessage.setText("Тестирование, 1, 2, 3. Меня слышно?");
            System.out.println("Отправка следующего сообщения: " + textMessage.getText());
            messageProducer.send(textMessage);
            textMessage.setText("Скопировал?");
            System.out.println("Отправка следующего сообщения: " + textMessage.getText());
            messageProducer.send(textMessage);
            textMessage.setText("До свидания!");
            System.out.println("Отправка следующего сообщения: " + textMessage.getText());
            messageProducer.send(textMessage);
            messageProducer.close();
            session.close();
            connection.close();
        } catch (JMSException jmsex) {
            jmsex.printStackTrace();
        }
    }

    public void main (String[] args) {
        new MessageSenderOld().produceMessages();
    }
}
