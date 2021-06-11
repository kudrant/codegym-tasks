package com.codegym.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    private static class Handler extends Thread {
        private Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            Connection connection = null;
            String newClient = null;

            try {
                ConsoleHelper.writeMessage("New connection has been established with the remote address " + socket.getRemoteSocketAddress());
                connection = new Connection(socket);
                newClient = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newClient));
                notifyUsers(connection, newClient);
                serverMainLoop(connection, newClient);
            }catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An error occurred while communicating with the remote address");
            } finally {
                if (newClient != null) {
                    connectionMap.remove(newClient);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newClient));
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            ConsoleHelper.writeMessage("Connection closed: " + socket.getRemoteSocketAddress());
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message = new Message(MessageType.NAME_REQUEST, "Please enter your name");
            Message receivedMessage;
            String name;

            while(true) {
                connection.send(message);
                receivedMessage = connection.receive();
                if (receivedMessage.getType().equals(MessageType.USER_NAME)) {
                    name = receivedMessage.getData();
                    if (!(name.isEmpty()) && !(connectionMap.containsKey(name))) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED, "Name accepted"));
                        return name;
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> connectEntry: connectionMap.entrySet()
                 ) {
                if (!connectEntry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, connectEntry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;
            while(true) {
                    message = connection.receive();
                    String textMessage = userName + ": " + message.getData();
                    if (message.getType().equals(MessageType.TEXT))
                        sendBroadcastMessage(new Message(MessageType.TEXT, textMessage));
                    else
                        ConsoleHelper.writeMessage("Message couldn't be sent");
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection: connectionMap.values()
             ) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Message couldn't be sent");
            }

        }
    }



    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Input server port: ");
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())){

            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Something wrong, Server socket closed.");
        }

    }
}
