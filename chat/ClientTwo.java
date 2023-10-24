/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author gamal
 */
public class ClientTwo {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Your Name: ");
        String name = scanner.nextLine();
        Client client2 = new Client("localhost", 8080, name);

        client2.receiveMessages();

        System.out.println("Chat Begenning");
        System.out.println("------------------------------------------------------------------------------------");
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("exit")) {
              break;
            }
            client2.sendMessage(input);
        }
      }
}
