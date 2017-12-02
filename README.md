# Programming With Sockets: Server

Simple server application:

- Listens on a specified port for a connection request from a client (class `ServerSocket`)
- Creates a socket for communication with this client (class `Socket`)
- Echoes every message received from the client back to the client

This server can connect only to a single client, and the server terminates when the client closes the connection.

Source: [Oracle Tutorials](https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html)

## Compile

### Compile only

~~~bash
mvn compile
~~~

### Compile and create executable JAR

~~~bash
mvn package
~~~

## Usage

~~~bash
java -jar my-server-1.0-SNAPSHOT.jar 4000
~~~

The argument (4000) is the port number on which the server listens for the connection of a client. It can be replaced by any valid port number.

The server terminates when the client sends an end-of-input character (Ctrl-D).
