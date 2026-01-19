package t3ejercicio4.b;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class serverTCP {
 public static void main(String[] args) {
    try {
            ServerSocket serverSocket = new
                    ServerSocket(12345);
             while (true) {
                 Socket clientSocket = serverSocket.accept();

                 try {
                     OutputStream outputStream =
                            clientSocket.getOutputStream();
                     PrintWriter out = new
                            PrintWriter(outputStream,
                             true);
                     out.println("Hola, cliente! eres: "+clientSocket.getRemoteSocketAddress());
                     } catch (IOException e) {
                     e.printStackTrace();
                    }


                InputStream inputStream =
                        clientSocket.getInputStream();
                BufferedReader in = new BufferedReader(new
                InputStreamReader(inputStream));


                float respuesta = Float.parseFloat(in.readLine());
                System.out.println("Mensaje del cliente: " +
                        (respuesta));
                clientSocket.close();
                }
            } catch (IOException e) {
            e.printStackTrace();
            }
        }
}