package com.codegym.task.task30.task3008.client;

import com.codegym.task.task30.task3008.Connection;
import com.codegym.task.task30.task3008.ConsoleHelper;
import com.codegym.task.task30.task3008.Message;
import com.codegym.task.task30.task3008.MessageType;

import javax.swing.plaf.BorderUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() throws IOException {
        ConsoleHelper.writeMessage("Please, enter the server address (numerical or \"localhost\")");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Please, enter the port number");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Please, enter your username");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Can't send your message");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                wait();

            }
            //notify();
        } catch (Exception e) {
            ConsoleHelper.writeMessage("An exception occurs while waiting");
            System.exit(0);
        }

        if (clientConnected)
            ConsoleHelper.writeMessage("Connection established. To exit, enter 'exit'.");
        else
            ConsoleHelper.writeMessage("An error occurred while working with the client.");

        String message;
        while (!(message = ConsoleHelper.readString()).equals("exit") && clientConnected) {
            if (shouldSendTextFromConsole())
                sendTextMessage(message);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Participant named " + userName + " has joined the chat.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Participant named " + userName + " has left the chat.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                MessageType messageType = connection.receive().getType();
                if (messageType == null)
                    throw new IOException("Unexpected MessageType");
                switch (messageType) {
                    case NAME_REQUEST:
                        connection.send(new Message(MessageType.USER_NAME, getUserName()));
                        break;
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        return;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message receivedMessage = connection.receive();
                if (receivedMessage.getType() == null)
                    throw new IOException("Unexpected MessageType");
                switch (receivedMessage.getType()) {
                    case TEXT:
                        processIncomingMessage(receivedMessage.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(receivedMessage.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(receivedMessage.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

    }
}
