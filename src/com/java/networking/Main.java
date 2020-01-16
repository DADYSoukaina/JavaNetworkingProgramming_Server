package com.java.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args){
        try(ServerSocket ServerSocket = new ServerSocket(5000)) {
            Socket socket = ServerSocket.accept();
            System.out.println("Client connected");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                String echoString = input.readLine();
                if (echoString.equals("exit")) {
                    break;
                }
                output.println("Echo from server: " + echoString);
            }
        }
        catch (IOException e){
            System.out.println("Server exception: "+ e.getMessage());
        }
    }
}
