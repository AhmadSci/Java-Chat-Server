/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat;

import java.io.IOException;

/**
 *
 * @author gamal
 */
public class ServerMain {
    public static void main(String[] args) throws IOException {

    Server server = new Server(8080);
    server.start();
  }

}
