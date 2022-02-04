package no.hvl.dat110.messaging;


import java.io.IOException;

import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingClient {

    private String server;
    private int port;

    public MessagingClient(String server, int port) {
        this.server = server;
        this.port = port;
    }

    // connect to messaging server
    public Connection connect() throws IOException {

        // TODO - START
        // create TCP socket for client and connection

        Socket clientSocket = new Socket(server, port);
        Connection connection = new Connection(clientSocket);

        // TODO - END
        return connection;
    }
}
