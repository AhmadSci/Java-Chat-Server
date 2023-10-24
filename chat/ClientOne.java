/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chat;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author gamal
 */
public class ClientOne {

     public static void main(String[] args) throws IOException, InterruptedException  {

        Scanner scanner = new Scanner(System.in);
        
         System.out.print("Your Name: ");
        String name = scanner.nextLine();

        Client client1 = new Client("localhost", 8080, name);

        client1.receiveMessages();
        
        System.out.println("Chat Begenning");
        System.out.println("------------------------------------------------------------------------------------");

        while(true) {
            String input = scanner.nextLine();
            if(input.equals("exit")) {
              break;
            }
            client1.sendMessage(input);
        }
      }

}
