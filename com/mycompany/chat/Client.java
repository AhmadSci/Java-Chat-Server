/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat;

import java.io.*;
import java.net.*;

public class Client {
  
  private Socket socket;
  private BufferedReader recieve;
  private PrintWriter send;
  private String username;

  public Client(String host, int port, String username) throws IOException {
    socket = new Socket(host, port);
    recieve = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    send = new PrintWriter(socket.getOutputStream(), true);
    this.username = username;
  }

  public void sendMessage(String message) {
    send.println(username + ": "+message );
  }

  public void receiveMessages() {
    new Thread(() -> {
      while(true) {
        try {
          String message = recieve.readLine();
          if(!message.startsWith(username))
            System.out.println(message);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }
}