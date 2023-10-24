# Multi-Client Chat Application

This is a simple chat application that allows multiple clients to connect to a server and chat with each other.

## Overview

- The application consists of a server and multiple chat clients 
- Clients connect to the server's socket and can send messages
- The server broadcasts each message to all connected clients
- Clients print the chat messages received from the server 

## Usage

- Start the Server first 
- Run multiple instances of ClientOne and ClientTwo to connect as clients
- Client provides console interface to send and receive messages

## Features

- Server uses threads to handle each client 
- Clients identified by unique names
- Broadcasts every message to all clients

## Running

`Server` contains the server implementation

`Client` contains the client implementation 

`ServerMain` is a sample driver class to run the server

`ClinetOne/Two` is a sample driver class to run the clients

Compile:

```
javac Server.java Client.java ClinetOne.java ClinetTwo.java ServerMain.java
```

Run server:

```
java ServerMain
``` 

Run each client in separate terminals:

```
java ClinetOne
java ClinetTwo
```

Clients can then start sending messages which will be broadcasted to all clients.

# Screenshots
![Server](/p/1.png)
![Server](/p/2.png)
![Server](/p/3.png)
