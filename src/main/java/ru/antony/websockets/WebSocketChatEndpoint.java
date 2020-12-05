package ru.antony.websockets;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint("/websocketchat")
public class WebSocketChatEndpoint {
    private static final Logger LOG = Logger.getLogger(WebSocketChatEndpoint.class.getName());

    @OnOpen
    public void connectionOpened() {
        LOG.log(Level.INFO, "connection opened");
    }

    @OnMessage
    public synchronized void processMessage(Session session, String message) {
        LOG.log(Level.INFO, "received message: {0}", message);

        try {
            for (Session sess : session.getOpenSessions()) {
                if (sess.isOpen()) {
                    sess.getBasicRemote().sendText(message);
                }
            }
        } catch (IOException ioe) {
            LOG.log(Level.SEVERE, ioe.getMessage());
        }
    }

    @OnClose
    public void connectionClose() {
        LOG.log(Level.INFO, "connection closed");
    }
}
