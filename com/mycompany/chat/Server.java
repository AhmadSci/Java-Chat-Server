/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

  private int port;
  private ArrayList<Socket> clientSockets;

  public Server(int port) {
    this.port = port;
    this.clientSockets = new ArrayList<>();
  }

  public void start() throws IOException {
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("Chat server running on port " + port); 
    while(true) {
      Socket client = serverSocket.accept();
      clientSockets.add(client);
      
      ClientHandler handler = new ClientHandler(client, this);
      handler.start();
    }
  }
  
  // broadcast message to all clients
  public void broadcast(String message) {
    for(Socket socket : clientSockets) {
      try {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(message);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}

// sub-Class that Handles Clients connection and message broadcasting
class ClientHandler extends Thread {
  private Socket client;
  private Server server;
  private BufferedReader in;

  public ClientHandler(Socket client, Server server) {
    this.client = client;
    this.server = server;
  }

  public void run() {
    try {
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      while(true) {
        String message = in.readLine();
        server.broadcast(message); 
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}