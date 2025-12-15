package t3ejercicio4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Crear un servidor que escucha en el puerto 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Servidor esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");

                Thread clientThread = new Thread(new ClienteHandler(clientSocket));
                clientThread.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}