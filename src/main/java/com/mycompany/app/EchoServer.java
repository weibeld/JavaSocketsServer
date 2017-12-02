package com.mycompany.app;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
public class EchoServer {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        
        int portNumber = Integer.parseInt(args[0]);
        
        try (
            // The socket used to listen to connections from clients
            ServerSocket ss = new ServerSocket(portNumber);
            // The socket used for communication with a specific client
            Socket cs = ss.accept();
            // For reading from the comm. socket (what's received from client)
            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            // For writing to the comm. socket (sent over channel to client)
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);                   
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                printMsg("receiving: " + inputLine);
                out.println(inputLine);
                printMsg("sending: " + inputLine + "\n");
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    private static void printMsg(String msg) {
        System.out.println(ts() + ": " + msg);
    }
    private static long ts() {
        return System.currentTimeMillis() / 1000L;
    }
}
